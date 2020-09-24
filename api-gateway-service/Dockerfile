FROM openjdk:12-jdk-alpine

ADD target/api-gateway-service-0.0.1-SNAPSHOT.jar api-gateway-service.jar
ENTRYPOINT ["java", "-jar", "/api-gateway-service.jar"]
EXPOSE 8085

