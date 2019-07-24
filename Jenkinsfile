pipeline {
  agent any
  stages {
    stage('checkout') {
      steps {
        git(url: 'https://github.com/balajireddy8898/spring-mvc-unit-test-sample.git', branch: 'master')
      }
    }
    stage('build') {
      steps {
        bat 'mvn clean install'
      }
    }
    stage('sonarqube') {
      steps {
        bat 'sonar-runner'
      }
    }
  }
}