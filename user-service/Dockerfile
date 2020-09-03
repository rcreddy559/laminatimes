FROM openjdk:12-jdk-alpine

ADD target/user-service.jar  user-service.jar
ENTRYPOINT ["java", "-jar", "/user-service.jar"]
EXPOSE 8084