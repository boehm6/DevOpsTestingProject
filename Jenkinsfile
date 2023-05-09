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
               bat './mvnw clean install'
           }
       }
       stage('Test Stage'){
        stages{
            stage('JUnittest'){
                 steps{
                    bat './mvnw test'
                 }
            }
            stage('Integrationtest'){
                 steps{
                     bat './mvnw verify -Psurefire'
                 }
            }
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
               junit(
                   testResults: "target/surefire-reports/TEST-*.xml",
                   keepLongStdio: false,
                   healthScaleFactor: 1.0,
                   allowEmptyResults: false,
                   skipPublishingChecks: false,
                   checksName: "Tests"
               )

               jacoco(
                   execPattern: "target/jacoco.exec",
                   classPattern: "target/classes/project",

                   sourcePattern: "**/src/main/java",
                   sourceInclusionPattern: "**/*.java"
               )

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