FROM adoptopenjdk
#MAINTAINER experto.dev <experto.dev>
#RUN addgroup -S spring && adduser -S spring -G spring
#USER spring:spring

VOLUME /var/lib/discovery-service
EXPOSE 8123
ARG APP_NAME_JAR=/home/spring/discovery-service.jar
ARG JAR_FILE=target/*.jar
ADD ${JAR_FILE} ${APP_NAME_JAR}
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/home/spring/discovery-service.jar"]