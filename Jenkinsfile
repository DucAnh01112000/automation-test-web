pipeline{
    agent any
    tools{
        maven 'Maven'
        jdk 'Java'
    }
    stages {
        stage('Checkout Code'){
            steps{
                git 'https://github.com/Sotatek-anhnguyen37/automation-test-web'
            }
        }
        stage('Compile Code'){
            steps{
                bat 'mvn compile'
            }
        }
        stage('Test Code'){
            steps{
                bat 'mvn clean test'
            }
        }
    }
}