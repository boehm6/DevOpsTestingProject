pipeline {
   agent any
   	tools {
   		jdk 'java-17'
   	}
   triggers{
   pollSCM('H */4 * * 1-5')
   }

   stages {
       stage('Build') {
           steps {
               bat 'mvnw clean install'
           }
       }
       stage('Test Stage'){
        stage('JUnittest'){
            steps{
               bat 'mvnw test'
            }
        }
        stage('Integrationtest'){
             steps{
                bat 'mvnw verify -Psurefire'
            }
        }

       }
       stage('Deploy') {
           steps {
               echo 'Deploying to artifact can be configured..'
           }
       }
   }
}