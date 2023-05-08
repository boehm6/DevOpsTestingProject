pipeline {
   agent any
   tools{
   jdk17
   }

   triggers{
   pollSCM('*****')
   }

   stages {
       stage('Build') {
           steps {
               sh 'mvnw clean package'
           }
       }
       stage('Test'){
            steps{
                sh 'mvnw test'
            }
       }
       stage('Run') {
           steps {
               sh 'java -jar target/DevOpsTesting.jar'
           }
       }
   }
}
