FROM openjdk:12-jdk-alpine

ADD target/api-gateway-service.jar api-gateway-service.jar
ENTRYPOINT ["java", "-jar", "/api-gateway-service.jar"]
EXPOSE 8085

