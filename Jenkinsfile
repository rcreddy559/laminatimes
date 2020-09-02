pipeline {
    agent any
 
    stages {
 
      stage('Build') {
      
        step {
            sh 'mvn clean install'
 
            def pom = readMavenPom file:'pom.xml'
            print pom.version
            env.version = pom.version
               }
        }
 
        stage('Image') {
        step {
            dir ('discovery-service') {
                def app = docker.build "localhost:5000/discovery-service:${env.version}"
                app.push()
            }
          }
        }
 
        stage ('Run') {
          step {
            docker.image("localhost:5000/discovery-service:${env.version}").run('-p 8761:8761 -h discovery --name discovery')
          }
        }
 
        
    }
 
}