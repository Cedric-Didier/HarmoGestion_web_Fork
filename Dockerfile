FROM eclipse-temurin:25-jre-alpine
RUN mkdir /opt/app
WORKDIR /opt/app
COPY ./target/harmoGestionWeb-0.0.1-SNAPSHOT.jar harmoGestionWeb.jar
EXPOSE 8080
CMD ["java","-jar","harmoGestionWeb.jar"]