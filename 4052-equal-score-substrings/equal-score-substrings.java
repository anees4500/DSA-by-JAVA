class Solution {
    public boolean scoreBalance(String s) {
        int sum = 0;
        for(int i = 0; i<s.length(); i++){
            sum += s.charAt(i)-'a'+1;
        }

        boolean isTrue = false;
        int sum1 =0;
        int com = 0;


        if(sum%2==0){
           com = sum/2;
        }
        else{

            return false;

        }


        for(int i = 0 ; i<s.length()-1; i++){
            sum1 += s.charAt(i)-'a'+1;
            if(sum1==com){
                return true;
            }
        }
        return false;
    }
}