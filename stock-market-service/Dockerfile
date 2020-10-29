FROM adoptopenjdk
#MAINTAINER experto.dev <experto.dev>
VOLUME /var/lib/stock-market-service
EXPOSE 8123
ARG APP_NAME_JAR=stock-market-service.jar
ARG JAR_FILE=build/libs/*.jar
ADD ${JAR_FILE} ${APP_NAME_JAR}
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","stock-market-service.jar"]