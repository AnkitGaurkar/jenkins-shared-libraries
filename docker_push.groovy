def call(String CredId, String imageName){

                withCredentials([usernamePassword(
                    credentialsId: "DockerHubCredID",
                    passwordVariable: "dockerHubPass",
                    usernameVariable: "dockerHubUser"
                    )]){
                sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
                sh "docker image tag  ${imageName} ${env.dockerHubUser}/${imageName}"
                sh "docker push ${env.dockerHubUser}/${imageName}:latest"
                    }
}
