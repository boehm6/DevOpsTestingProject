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
               bat 'mvnw clean package'
           }
       }
       stage('Test'){
            steps{
                bat 'mvnw test'
            }
       }
       stage('Deploy') {
           steps {
               echo 'Deploying to artifact can be configured..'
           }
       }
   }
