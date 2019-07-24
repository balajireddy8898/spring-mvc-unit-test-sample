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
    stage('Sonarqube') {
      steps {
        bat 'mvn sonar:sonar'
        bat 'mvn clean install'
      }
    }
  }
}
