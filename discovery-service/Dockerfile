FROM openjdk:12-jdk-alpine


# Required for starting application up.
RUN apk update && apk add /bin/sh

RUN mkdir -p /opt/app
ENV PROJECT_HOME /opt/app

COPY  target/discovery-service-0.0.1-SNAPSHOT.jar  $PROJECT_HOME/discovery-service.jar

WORKDIR $PROJECT_HOME

CMD ["java" ,"-jar","./discovery-service.jar"]

EXPOSE 8761

