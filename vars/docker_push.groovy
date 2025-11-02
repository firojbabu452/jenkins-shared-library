def call(String project, String imageTag, String dockerHubUserParam) {
    withCredentials([usernamePassword(credentialsId: 'dockerHubCredentials', 
                                      usernameVariable: 'DOCKER_USER', 
                                      passwordVariable: 'DOCKER_PASS')]) {
        sh """
            #!/bin/bash
            echo "\$DOCKER_PASS" | docker login -u "\$DOCKER_USER" --password-stdin
            docker tag ${project}:${imageTag} "\$DOCKER_USER/${project}:${imageTag}"
            docker push "\$DOCKER_USER/${project}:${imageTag}"
        """
    }
}
