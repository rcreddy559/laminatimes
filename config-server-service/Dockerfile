FROM openjdk:12-jdk-alpine

ADD target/config-server-service.jar config-server-service.jar
ENTRYPOINT ["java", "-jar", "/config-server-service.jar"]
EXPOSE 8888

