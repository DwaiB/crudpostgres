pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "maven-3.9.9"
    }
    stages {
        stage('Build Maven') {
            steps {
				script{
					withCredentials([string(credentialsId: 'postgres_uname', variable: 'postgres_username'), string(credentialsId: 'postgres_pwd', variable: 'postgres_password')]) {
					    // some block
					    // Get some code from a GitHub repository
		                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/DwaiB/crudpostgres']])
		
		                // Run Maven on a Unix agent.
		                sh "mvn clean install -Dpostgres_uname=${postgres_username} -Dpostgres_pwd=${postgres_password}"

					}
				}
                
            }
        }
        stage('Build Docker Image') {
            steps {
                
                script{
                    sh "docker build -t aesterix/crudpostgres ."
                }
            }
        }
        stage('Push Image to Hub') {
            steps {
                
                script{
                    withCredentials([string(credentialsId: 'docker_pwd', variable: 'dockerpwd')]) {
                        sh 'docker login -u aesterix -p ${dockerpwd}'
                    }
                    sh ' docker push aesterix/crudpostgres'
                }
            }
        }
    }
}
