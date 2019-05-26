pipeline {
    agent any
	tools{
		maven 'Maven'
		jdk 'jdk'
	}
    stages {
        stage('Build') { 
            steps {
                bat 'mvn clean' 
            }
	}
	 stage('Install') {
            steps {
                bat 'mvn install'
            }
	 }
	    stage('Sonar'){
		    steps{
		    bat 'mvn sonar:sonar -Dsonar.host.url=http://localhost:9000 -Dsonar.login=d9b8082d2e909663d06cf394f1b38e51e07e292a -Dsonar.analysis.mode=publish -Dsonar.projectKey=jee2' 
		    }
	    }
     }
}
