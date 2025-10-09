class Solution {

    public int helper(int[] coins, int amount ,int i, int dp[][]){
        if(i==coins.length){
            return 0;
        }

        if(amount==0){
            return 1;
        }

        if(amount<0){
            return 0;
        }

        if(dp[i][amount]!=-1){
            return dp[i][amount];
        }

        return dp[i][amount] =  helper(coins,amount-coins[i], i, dp) +  helper(coins,amount, i+1,dp);
    }
     
    public int change(int amount, int[] coins) {
        int dp[][] = new int[coins.length][amount+1];

        for(int i = 0; i<coins.length; i++){
            Arrays.fill(dp[i],-1);
        }

        return helper(coins,amount, 0,dp);

    



        

        
         
    }
}