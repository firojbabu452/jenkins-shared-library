def call(String branch,String url){

   echo 'Cloning the code'
   git branch: "${branch}", url: "${url}"
   echo 'Cloning successful'
}
