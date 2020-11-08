pipeline {
    agent any 
    environment {
        APP_NAME = "laminatimes"
        BUILD_NUMBER = "${env.BUILD_NUMBER}"
        IMAGE_VERSION="v_${BUILD_NUMBER}"
        GIT_URL="git@github.com:ravichandrap/laminatimes.git"
        GIT_CRED_ID='izleka2IGSTDK+MiYOG3b3lZU9nYxhiJOrxhlaJ1gAA='
        REPOURL = 'cL5nSDa+49M.dkr.ecr.us-east-1.amazonaws.com'
        SBT_OPTS='-Xmx1024m -Xms512m'
        JAVA_OPTS='-Xmx1024m -Xms512m'
        WS_PRODUCT_TOKEN='FJbep9fKLeJa/Cwh7IJbL0lPfdYg7q4zxvALAxWPLnc='
        WS_PROJECT_TOKEN='zwzxtyeBntxX4ixHD1iE2dOr4DVFHPp7D0Czn84DEF4='
        HIPCHAT_TOKEN = 'SpVaURsSTcWaHKulZ6L4L+sjKxhGXCkjSbcqzL42ziU='
        HIPCHAT_ROOM = 'NotificationRoomName'
    }

    tools {
        maven: 'M3'
    }
    stages {
        stage('SCM Checkout') {
            steps {
                echo 'Hello world!';
                git branch: 'develop', url: 'https://github.com/ravichandrap/laminatimes.git'
            }
        }

        stage('MVN Checkout') {
            steps {
                echo 'Hello world!';
                def mvnHome = tool name: 'Apache Maven 3.6.0', type: 'maven'
                sh "${mvnHome}/bin/mvn -B -DskipTests clean package"
            }
        }
    }
}