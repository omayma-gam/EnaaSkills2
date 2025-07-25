pipeline {
    agent any

    tools {
        maven 'maven' // Matches the name you configured
    }

    environment {
        GIT_REPO = 'https://github.com/omayma-gam/EnaaSkills2'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: "${GIT_REPO}"
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }

    }


}
