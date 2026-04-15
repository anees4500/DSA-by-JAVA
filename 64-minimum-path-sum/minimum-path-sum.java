class Solution {

    public int dfs(int[][] grid, int i, int j, int[][] dp){

        // out of bound
        if(i < 0 || j < 0){
            return Integer.MAX_VALUE;
        }

        // base case
        if(i == 0 && j == 0){
            return grid[0][0];
        }

        // memo check
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int up = dfs(grid, i-1, j, dp);
        int left = dfs(grid, i, j-1, dp);

        return dp[i][j] = Math.min(up, left) + grid[i][j];
    }

    public int minPathSum(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];

        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }

        return dfs(grid, n-1, m-1, dp);
    }
}