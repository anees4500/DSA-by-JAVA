class Solution {

    int dp[];
    public int coinChangeHelper(int[] coins  , int amount){

        if(amount< 0){
            return 1_000_000_007 ;
        }
        if(amount==0){
            return 0;
        }

         

        if(dp[amount]!=-1){
            return dp[amount];
        }
        
        int ans = 1_000_000_007;

        for(int i = 0 ; i<coins.length; i++){
            ans = Math.min(ans , coinChangeHelper(coins,    amount - coins[i]) + 1);
        }

        return dp[amount] = ans;
    }
    public int coinChange(int[] coins, int amount) {

        dp = new int[amount+1];

        

        Arrays.fill(dp , -1) ;

        dp[0] = 0;

        coinChangeHelper(coins,amount);

        if(dp[amount]==1_000_000_007){
            return -1;
        }

        return dp[amount];
        
    }
}