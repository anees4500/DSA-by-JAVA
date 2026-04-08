class Solution {
    
    public int strangePrinter(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        
        return solve(s, 0, n - 1, dp);
    }
    
    private int solve(String s, int i, int j, int[][] dp) {
        
        if(i > j) return 0;
        if(i == j) return 1;
        
        if(dp[i][j] != 0) return dp[i][j];
        
        // default case
        int ans = 1 + solve(s, i + 1, j, dp);
        
        // try to merge same characters
        for(int k = i + 1; k <= j; k++){
            if(s.charAt(i) == s.charAt(k)){
                int temp = solve(s, i, k - 1, dp) + solve(s, k + 1, j, dp);
                ans = Math.min(ans, temp);
            }
        }
        
        return dp[i][j] = ans;
    }
}