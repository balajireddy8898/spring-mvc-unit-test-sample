pipeline {
  agent any
  stages {
    stage('checkout') {
      steps {
        git(url: 'https://github.com/balajireddy8898/spring-mvc-unit-test-sample.git', branch: 'master')
      }
    }
    stage('compile') {
      steps {
        bat 'mvn compile'
      }
    }
    stage('JunitTest') {
      steps {
        bat 'mvn test'
      }
    }
    stage('build') {
      steps {
        bat 'mvn clean install'
      }
    }
    stage('Sonarqube') {
      steps {
        bat 'mvn sonar:sonar'
      }
    }
    stage('deploy') {
      steps {
        bat 'xcopy "C:\\Program Files (x86)\\Jenkins\\workspace\\banu7_master\\target\\spring-mvc-unit-test-sample-1.2.0-SNAPSHOT.war" "C:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps" '
      }
    }
  }
}