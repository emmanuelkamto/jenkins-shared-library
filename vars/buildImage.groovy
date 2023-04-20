#!/usr/bin/env groovy

def call() {
    echo "Building the application..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repos', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t emmanuelkamto/demo-app:jma-2.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push emmanuelkamto/demo-app:jma-2.0'
    }
}