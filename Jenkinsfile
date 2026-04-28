pipeline {
    agent any
    /*environment {
        registryUrl = "cedricdidier/harmogestion_web"
        registryCredentialsId = 'DockerHubAccount'
    }*/
    tools {
        maven 'maven'
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
        stage('Build Maven') {
            steps {
                bat 'mvn clean package'
            }
        }
        stage('Generate Allure Report') {
            steps {
                bat 'mvn allure:report'
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