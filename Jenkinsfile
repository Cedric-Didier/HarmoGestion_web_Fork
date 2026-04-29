pipeline {
    agent any
    environment {
        registryCredentialsId = 'DockerHubAccount'
        dockerImageName = 'cedricdidier/harmogestion_web:latest'
    }
    node{
        env.NODEJS_HOME = "${tool 'NodeJs'}"
        env.PATH="${env.NODEJS_HOME};${env.PATH}"
        bat 'npm --version'
    }
    tools {
        maven 'Maven'
        jdk 'JAVA_25'
    }
    stages {
        stage('Clean workspace') {
            steps {
                cleanWs()
            }
        }
        stage('Git checkout') {
            steps {
                script {
                    git branch: 'main',
                    url: 'https://github.com/Cedric-Didier/HarmoGestion_web_Fork.git'
                }
            }
        }
        stage('Build npm'){
            // Récupération de bootstrap via npm
            steps {
                script {
                    bat 'cd ./src/main/resources/static; npm install; cd ../../../..'
                }
            }
        }
        stage('Build Maven') {
            steps {
                script {
                    bat 'mvn clean package'
                }
            }
        }
        stage('Generate Allure Report') {
            steps {
                script {
                    bat 'mvn allure:report'
                }
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    docker.build(dockerImageName, '-f Dockerfile .')
                }
            }
        }
        stage('Push Image To Docker Hub') {
            steps{
                script {
                    docker.withRegistry('', registryCredentialsId) {
                        docker.image(dockerImageName).push()

                    }
                }
            }
        }
        stage('Deploy Container') {
            steps {
                script {
                    bat 'docker-compose up -d --build --force-recreate --remove-orphans'
                }
            }
        }
    }
    post {
        always {
            allure([
                includeProperties: false,
                jdk: '',
                properties: [],
                reportBuildPolicy: 'ALWAYS',
                results: [[path: 'target/allure-results']]
            ])
        }
    }
}