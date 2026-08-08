pipeline {
    agent any

    environment {
        APP_NAME = 'ci-cd-demo-app'
        IMAGE_TAG = "${BUILD_NUMBER}"
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Test') {
            steps {
                dir('app') {
                    sh 'mvn clean test'
                }
            }
            post {
                always {
                    junit 'app/target/surefire-reports/*.xml'
                }
            }
        }

        stage('Package') {
            steps {
                dir('app') {
                    sh 'mvn package -DskipTests'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                dir('app') {
                    sh """
                        docker build \
                          -t ${APP_NAME}:${IMAGE_TAG} \
                          .
                    """
                }
            }
        }

        stage('Verify Docker Image') {
            steps {
                sh """
                    docker image inspect \
                      ${APP_NAME}:${IMAGE_TAG}
                """
            }
        }
    }

    post {
        success {
            echo "Pipeline completed successfully."
        }

        failure {
            echo "Pipeline failed."
        }
    }
}