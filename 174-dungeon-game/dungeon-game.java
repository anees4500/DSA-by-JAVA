 class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int dp[][] = new int[dungeon.length][dungeon[0].length];

        for(int i = 0; i<dungeon.length; i++){
            for(int j = 0; j<dungeon[0].length; j++){
                dp[i][j] = -1;
            }
        } 

        int n = dungeon.length;
        int m = dungeon[0].length;


        for(int i =n -1; i>=0; i--){
            for(int j = m-1; j>=0; j--){
                if(i == n-1 && j == m-1){
                    dp[i][j] = Math.min(0, dungeon[i][j]);
                }
                else if(i==n-1 ){
                    dp[i][j] = Math.min(0,dp[i][j+1]+dungeon[i][j]);
                }
                else if(j==m-1){
                     dp[i][j] = Math.min(0,dp[i+1][j]+ dungeon[i][j]);
                }
                else{
                    dp[i][j] = Math.min(0,dungeon[i][j] + Math.max(dp[i+1][j] , dp[i][j+1]));
                }


            }
        }

        return Math.abs(dp[0][0])+1;
    }
}
