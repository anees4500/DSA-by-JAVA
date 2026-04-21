class Solution {
    public int count(String s , int i , int j ,int dp[][]){
        if(i>j){
            return 0 ;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(i==j){
            return 1;
        }

        if(s.charAt(i)==s.charAt(j)){
            return dp[i][j] =  2 + count(s,i+1,j-1 , dp);
        }
        else{
            return dp[i][j] = Math.max(count(s,i+1,j , dp),count(s,i,j-1 , dp));
        }
    }
    public int longestPalindromeSubseq(String s) {

        int n = s.length();

        int dp[][] = new int[n][n];

        for(int i  = 0; i<n; i++){
            Arrays.fill(dp[i] , -1);
        }

        return count(s,0, s.length()-1 , dp);


    }
}