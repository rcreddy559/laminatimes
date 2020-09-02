FROM openjdk:12-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} holidays.jar
ENTRYPOINT ["java","-jar","/holidays.jar"]

EXPOSE 8088