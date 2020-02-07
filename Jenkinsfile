node {
 try  {
 notify('Job Started') 

     
  stage('Git-Checkout') {
   git 'https://github.com/chakri1998/Hotel.git'
  }
  stage('Input to continue forther') {
   input('git checkout done Do you want to forther proceed?')  
  }
  stage('Maven-Clean') {
   sh label: 'CLEAN', script: 'mvn clean'
  }
    
 stage('Maven-Compile') {
   sh label: 'COMPILE', script: 'mvn compile'
  }
  stage('Sonar Analysis'){
        withSonarQubeEnv('SonarQube'){
         sh 'mvn sonar:sonar'
        }
        }
  
   stage('Maven-Test') {
   sh label: 'TEST', script: 'mvn test'
  }
  
   stage('Maven-Package') {
   sh label: 'PACKAGE', script: 'mvn package'
  }
  
   stage('Archive-Artifacts') {
   archiveArtifacts 'target/*.war'
  }
  
   stage('Jfrog Artifacory Upload') {
        def server= Artifactory.server 'Artifactory'
                    def uploadSpec= """{
                        "files": [{
                        "pattern": "/root/.jenkins/workspace/devops/devops/target/*.war",
                        "target": "hotel"}]
                    }"""
        server.upload(uploadSpec)
        
        }
     
    stage('Jfrog Artifactory download'){
    def server= Artifactory.server 'Artifactory'
    def downloadSpec = """{
    "files": [
    {
      "pattern": "hotel/*.war",
      "target": "/home/mtadminnuvepro/artifacts/"
      
    }
    ]
    }"""
    server.download(downloadSpec)
   
}
  stage('Input for deploy in test server') {  
   input('Do you want to test server proceed?')      
        }
   stage('Docker-Stage-Deployment') {
   sh label: '', script: 'docker-compose up -d --build'
  }
	 
 stage('Input for deploy in production server') {            
   input('Do you want to deploy into production server proceed?')
        }
  stage('Geting Ready For Ansible') {
  sh label: 'Jenkins', script: "echo '<h1> TASK BUILD ID: ${env.BUILD_DISPLAY_NAME}</h1>' > index.html"
}  
   
   stage('Prod Deployment on AWS'){
   sh label: 'terraform', script: '/bin/terraform  init'
   sh label: 'terraform', script: '/bin/terraform  apply -input=false -auto-approve'
   }

notify('Job Completed')   
} catch (err) {
  notify("Error ${err}")
  currentBuild.result = 'FAILURE'
}
}

def notify(status){
    emailext (
	to: "chakradhar1998@outlook.com",
	subject: "${status}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
	 body: """<p>${status}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
	<p>Check console output at <a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a></p>""",
		)
	}
