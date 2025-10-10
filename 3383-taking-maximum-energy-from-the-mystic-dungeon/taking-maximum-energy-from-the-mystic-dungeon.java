 class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] dp = new int[n];
        int ans = Integer.MIN_VALUE;

        // Start from end → base cases
        for (int i = n - 1; i >= 0; i--) {
            if (i + k >= n) {
                dp[i] = energy[i];
            } else {
                dp[i] = energy[i] + dp[i + k];
            }

            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}
