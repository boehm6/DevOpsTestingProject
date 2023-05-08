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