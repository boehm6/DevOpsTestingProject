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

   post {
           always {
               echo "I will always get executed"
           }
           success {
               echo "I will be executed if the build is success"
           }
           failure {
               echo "I will be executed if the build fails"
           }
           unstable {
               echo "I will be executed if the build is unstable"
           }
       }
}