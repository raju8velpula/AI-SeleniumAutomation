
pipeline {
    agent any
    
    tools {
        maven 'Maven-3.8.1'  
        jdk 'JDK11'          
    }

    stages {
        stage('Build') {
            steps {
              bat 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                echo "Testing..."
            }
        }
        stage('Deploy') {
            steps {
                echo "Deploying..."
            }
        }
    }
}
