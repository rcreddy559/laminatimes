FROM openjdk:12-jdk-alpine

ADD target/holidays-service.jar holidays-service.jar
ENTRYPOINT ["java", "-jar", "/holidays-service.jar"]

EXPOSE 8088

