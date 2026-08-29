 

class Solution {

    static final int INF = 1000000;

    public int help(int[] coins, int idx, int amt, int[][] dp) {

        // Successfully made the amount
        if (amt == 0) {
            return 0;
        }

        // No coins left, but amount is still remaining
        if (idx < 0) {
            return INF;
        }

        if (dp[idx][amt] != -1) {
            return dp[idx][amt];
        }

        // Don't take the current coin
        int notTake = help(coins, idx - 1, amt, dp);

        // Take the current coin
        int take = INF;

        if (coins[idx] <= amt) {
            take = 1 + help(coins, idx, amt - coins[idx], dp);
        }

        return dp[idx][amt] = Math.min(take, notTake);
    }

    public int coinChange(int[] coins, int amount) {

        int n = coins.length;

        int[][] dp = new int[n][amount + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int ans = help(coins, n - 1, amount, dp);

        return ans >= INF ? -1 : ans;
    }
}