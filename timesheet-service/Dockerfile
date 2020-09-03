FROM openjdk:12-jdk-alpine

ADD target/timesheet-service.jar  timesheet-service.jar
ENTRYPOINT ["java", "-jar", "/timesheet-service.jar"]

EXPOSE 8089