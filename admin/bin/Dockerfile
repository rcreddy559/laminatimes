FROM openjdk:12-jdk-alpine

ADD target/admin.jar admin.jar
ENTRYPOINT ["java", "-jar", "/admin.jar"]
EXPOSE 8084
