pipeline {
    environment {
        ossrhPassword=credentials('ossrh-plw-password')
        ossrhSignKeyFile=credentials('ossrh-plw-signing-keyringfile')
    }

    agent: any

    stages {
        stage('Build') {
            steps {
                withGradle {
                    sh './gradlew clean build'
                }
                archiveArtifacts artifacts: 'lib/build/libs/*.jar', fingerprint: true, followSymlinks: false, onlyIfSuccessful: true
            }
        }
        stage('Deploy') {
            steps {
                withGradle {
                    sh '''
                    ./gradlew publish \
                    -PossrhUsername=PinkLemonadeWizard \
                    -PossrhPassword=${ossrhPassword} \
                    -Psigning.keyId=BBCE4E01 \
                    -Psigning.password=${ossrhPassword} \
                    -Psigning.secretKeyRingFile=${ossrhSignKeyFile}
                    '''
                }
            }
        }
    }
}