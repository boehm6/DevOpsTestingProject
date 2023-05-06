pipeline {
   agent any
   stages {
       stage('Build') {
           steps {
               sh 'mvn clean package'
           }
       }
       stage('Run') {
           steps {
               sh 'java -jar target/my-spring-boot-app.jar'
           }
       }
   }
}
