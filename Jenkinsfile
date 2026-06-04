pipeline {
    agent any

    triggers {
        cron('0 20 * * *')   // 8 PM daily
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn clean test -Dfile.encoding=UTF-8'
            }
        }
    }

    post {

        always {

            archiveArtifacts artifacts: '**/Project_18N_Reports/**', allowEmptyArchive: true

            publishHTML([
                reportDir: 'Project_18N_Reports',
                reportFiles: 'index.html',
                reportName: 'Extent Report',
                keepAll: true,
                allowMissing: true,
                alwaysLinkToLastBuild: true
            ])

            echo "================================="
            echo " REPORT LINK"
            echo "${env.BUILD_URL}Extent_20Report/"
            echo "================================="
        }
    }
}