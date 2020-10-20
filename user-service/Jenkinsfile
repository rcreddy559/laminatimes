pipeline {
    agent any
    tools {
        maven 'M3'
    }
    stages {
        stage ('Initialize') {
            steps {
                echo "Initialize success"
            }
        }

        stage ('Build') {
            steps {
                 sh 'mvn -Dmaven.test.failure.ignore=true install'
            }
            post {
                success {
                    echo "------- Post Build ----------"
                }
            }
        }

        stage ('JUnit Test') {
            steps {
                 sh 'mvn -Dmaven.test.failure.ignore=true test'
            }
            post {
                success {
                    echo "------- JUnit Test Pass  ----------"
                    junit 'target/surefire-reports/**/*.xml'
                }
            }
        }
        stage ('Deploy') {
                    steps {
                         sh 'mvn -Dmaven.test.failure.ignore=true package'
                    }
                    post {
                        success {
                            echo "------- Package done  ----------"
                        }
                    }
                }
    }
}
