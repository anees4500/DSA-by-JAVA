class Solution {
    public int helper(int[] coins, int amount, int i , int[][] dp){
         
        if(i ==coins.length || amount<0)return (int) 1e9;

        if(amount==0){
            return 0;
        }
        if(dp[i][amount]!=-1){

            return dp[i][amount];

        }

        return dp[i][amount] = Math.min(1+ helper(coins,amount-coins[i], i , dp), helper(coins,amount,i+1 , dp));
    }
    public int coinChange(int[] coins, int amount) {

        int[][] dp = new int[coins.length][amount+1];


        for(int i = 0; i<coins.length; i++){

            Arrays.fill(dp[i],-1);
        }


        int ans = helper(coins, amount, 0 , dp);
        return ans >= 1e9 ? -1 : ans;
    }
}