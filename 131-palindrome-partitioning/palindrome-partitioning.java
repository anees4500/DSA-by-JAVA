class Solution {

    public void help(int index, String str , List<String> path , List<List<String>> result ){

        if(index == str.length()){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = index ; i<str.length(); i++){

        

            if(isPalindrome(str.substring(index, i+1))){

                path.add(str.substring(index,i+1));
                help(i+1, str, path,result);

                path.remove(path.size()-1);



                
            }
        }
    }

    public boolean isPalindrome(String str){
        int i = 0;
        int j = str.length()-1;
        while(i<=j){
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }
            i++;
            j--;

        }
        return true;
    }


    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();

        List<String> path = new ArrayList<>();

        help(0 , s, path,result);

        return result;


    }
}