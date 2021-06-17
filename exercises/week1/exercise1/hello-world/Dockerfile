FROM openjdk:16-jdk-alpine

LABEL version="1.0"
LABEL author="syd@me"

RUN apk add curl

COPY target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
