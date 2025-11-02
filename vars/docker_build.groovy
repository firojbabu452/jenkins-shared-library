def call (String ProjectName,String imageTag,String DockerHubUser){
sh "docker build -t ${DockerHubUser}/${ProjectName}:${imageTag} . "

}
