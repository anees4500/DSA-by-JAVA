class Solution {

    public int dfs(int[][] grid , int n , int m ,int dp[][]){

        

        if(n<0 || m<0){
            return 0;
        }

        if(grid[n][m]==1){
            return 0;
        }

        

        if(n==0 && m==0){
            return 1;
        }

        

        if(dp[n][m]!=-1){
            return dp[n][m];
        }

        return dp[n][m] = dfs(grid,n-1,m,dp) + dfs(grid,n,m-1,dp);
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        int dp[][] = new int[n][m];

        for(int i = 0; i<n; i++){
            Arrays.fill(dp[i] , -1);
        }

        return dfs(obstacleGrid,n-1,m-1, dp);


    }
}