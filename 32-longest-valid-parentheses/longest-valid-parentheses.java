class Solution {
    public int longestValidParentheses(String s) {
         

        int max = 0;

        int open = 0;
        int close = 0;


        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch=='('){
                open++;
            }
            else{
                close++;
            }

            if(open==close){
                max = Math.max(open+close , max);
            }
            else if(close>open){
                open = close = 0;
            }
        }

        open = close = 0;

        for(int i = s.length()-1; i>=0; i--){
            char ch = s.charAt(i);

            if(ch=='('){
                open++;
            }
            else{
                close++;
            }

            if(open==close){
                max = Math.max(open+close , max);
            }
            else if(open>close){
                open = close = 0;
            }
        }

        return max ;

        
    }
}