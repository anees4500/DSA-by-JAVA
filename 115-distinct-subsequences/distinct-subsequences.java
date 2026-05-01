class Solution {

    Integer[][] dp ;
    public int helper(String s , String t , int i , int j){

        if(j==t.length()){
            return 1;
        }

        if(i==s.length()){
            return 0;
        }

        if(dp[i][j]!=null){
            return dp[i][j];
        }

        



        int skip = 0;
        int take  = 0;


         
        
        if(s.charAt(i)==t.charAt(j)){
             
            take = helper(s,t,i+1,j+1);
             


        }

        skip = helper(s,t,i+1,j);

        return dp[i][j] = take + skip;
    }


    public int numDistinct(String s, String t) {

        dp = new Integer[s.length()][t.length()];



        return helper(s,t,0,0);

    


        
    }
}