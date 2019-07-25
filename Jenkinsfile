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
    stage('sonarQube') {
      steps {
        bat 'mvn sonar:sonar'
      }
    }
    stage('deploy') {
      steps {
        bat 'app.bat'
      }
    }
  }
}