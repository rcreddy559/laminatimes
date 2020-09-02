pipeline {
    agent any
 
    stages {
 
      stage('Build') {
      
        steps {
            sh 'mvn clean install'
 
            print pom.version
           
               }
        }
 
        stage('Image') {
        steps {
            dir ('discovery-service') {
               
              
            }
          }
        }
        
    }
 
}