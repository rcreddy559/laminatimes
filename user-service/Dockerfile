FROM adoptopenjdk
#MAINTAINER experto.dev <experto.dev>
VOLUME /var/lib/user-service
EXPOSE 8123
ARG APP_NAME_JAR=user-service.jar
ARG JAR_FILE=target/*.jar
ADD ${JAR_FILE} ${APP_NAME_JAR}
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","user-service.jar"]