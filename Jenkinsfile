
pipeline {
    agent any
    
   

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
    post {
        success {
            echo 'declarative-pipeline'
            build job: 'declarative-pipeline',
                  wait: false,       // true = wait for result
                  propagate: false   // do not fail A if B fails
        }
    }
}
