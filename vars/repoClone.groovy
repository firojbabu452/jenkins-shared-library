def call(String url,String branch){

   echo 'Cloning the code'
   git branch: "${branch}", url: "${url}"
   echo 'Cloning successful'
}
