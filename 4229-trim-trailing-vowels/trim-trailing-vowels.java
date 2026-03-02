class Solution {

    public boolean isVowel(char ch){
        if(ch=='a' || ch=='e' ){
            return true;
        }
        else if(ch=='i'){
            return true;
        }
        else if(ch=='o'){
            return true;
        }
        else if(ch=='u'){
            return true;
        }
        
        return false;
        
    }
    public String trimTrailingVowels(String s) {
        StringBuilder sb = new StringBuilder();

        // for(int i = s.length()-1; i>=0; i--){
        //     if(isVowel(s.charAt(i))){
        //         s = s.substring(0,i)+ "";
        //     }else{
        //         return  s;
        //     }
        // }

        int idx = -1;


        for(int i = s.length()-1; i>=0; i--){
            if(isVowel(s.charAt(i))){
                continue;
            }
            else{
                idx = i;
                break;
            }
        }

        if(idx==-1){
            return "";
        }

        for(int i = 0; i<=idx; i++){
            sb.append(s.charAt(i));
        }




        return sb.toString();
    }
}