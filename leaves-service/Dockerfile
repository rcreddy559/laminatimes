FROM openjdk:12-jdk-alpine
ADD target/leaves-service.jar leaves-service.jar
ENTRYPOINT ["java", "-jar", "/leaves-service.jar"]

EXPOSE 8086