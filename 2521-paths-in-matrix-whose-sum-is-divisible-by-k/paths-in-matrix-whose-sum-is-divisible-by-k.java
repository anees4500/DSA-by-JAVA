class Solution {

    static Integer dp[][][];
    int n, m, k;
    int[][] grid;
    int mod = 1_000_000_007;

    public int dfs(int i, int j, int sum) {

        if (i >= n || j >= m) return 0;

        sum = (sum + grid[i][j]) % k;

        if (i == n - 1 && j == m - 1) {
            return sum == 0 ? 1 : 0;
        }

        if (dp[i][j][sum] != null) {
            return dp[i][j][sum];
        }

        int down = dfs(i + 1, j, sum);
        int right = dfs(i, j + 1, sum);

        return dp[i][j][sum] = (down + right) % mod;
    }

    public int numberOfPaths(int[][] grid, int k) {

        this.grid = grid;
        this.k = k;
        n = grid.length;
        m = grid[0].length;

        dp = new Integer[n][m][k];

        return dfs(0, 0, 0);
    }
}
