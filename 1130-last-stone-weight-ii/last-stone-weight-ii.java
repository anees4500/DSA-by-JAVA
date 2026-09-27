class Solution {

    int dp[][];

    public int help(int[] stones, int i, int target) {

        if (i == stones.length || target == 0) {
            return 0;
        }

        if (dp[i][target] != -1) {
            return dp[i][target];
        }

        int nt = help(stones, i + 1, target);

        int take = 0;

        if (target >= stones[i]) {
            take = stones[i] +
                   help(stones, i + 1, target - stones[i]);
        }

        return dp[i][target] = Math.max(take, nt);
    }

    public int lastStoneWeightII(int[] stones) {

        int sum = 0;

        for (int x : stones) {
            sum += x;
        }

        int target = sum / 2;

        dp = new int[stones.length][target + 1];

        for (int i = 0; i < stones.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        int best = help(stones, 0, target);

        return sum - 2 * best;
    }
}