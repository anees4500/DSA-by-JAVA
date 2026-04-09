class Solution {
    public int helper(int m,int n, int[][] dp){

        if(m==0 && n==0){
            return 1;
        }

        if(m==0 || n==0){
            return 1;
        }

        if(dp[m][n]!=-1){
            return dp[m][n];
        }



        return dp[m][n] =  helper(m, n-1 , dp) +  helper(m-1,n,dp);
    }

    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m+1][n+1];

        for(int i = 1; i<m+1; i++){
            for(int j = 1; j<n+1; j++){
                dp[i][j]= -1;
            }
        }
        return helper(m-1,n-1,dp);
    }
}