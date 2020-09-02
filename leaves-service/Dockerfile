FROM openjdk:12-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} leaves.jar
ENTRYPOINT ["java","-jar","/leaves.jar"]

EXPOSE 8086