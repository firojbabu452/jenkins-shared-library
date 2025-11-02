def call(String Project, String ImageTag, String dockerHubUser){
     withCredentials([usernamePassword(credentialsId: 'dockerHubCredentials', passwordVariable: 'dockerHubPass', usernameVariable: 'dockerHubUser')]) {
                    sh '''
                        #!/bin/bash
                        echo "$dockerHubPass" | docker login -u "$dockerHubUser" --password-stdin
                        docker tag notes-app:latest "$dockerHubUser/django-notes-app:latest"
                        docker push "$dockerHubUser/$Project:$ImageTag"
                    '''
                }
}
