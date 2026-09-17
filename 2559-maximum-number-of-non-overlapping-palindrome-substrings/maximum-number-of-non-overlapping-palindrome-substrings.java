class Solution {

    static boolean vis[][];

    public int solve(String s, int i, int j, int[][] dp, int k) {

        if (j >= s.length() || i >= s.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = 0;

        // Current [i...j] palindrome hai
        // aur length >= k hai
        if (vis[i][j] && (j - i + 1 >= k)) {

            int take = 1 + solve(
                s,
                j + 1,
                Math.min(j + k, s.length() - 1),
                dp,
                k
            );

            int grow = solve(
                s,
                i,
                j + 1,
                dp,
                k
            );

            int slide = solve(
                s,
                i + 1,
                j + 1,
                dp,
                k
            );

            ans = Math.max(take, Math.max(grow, slide));

        } else {

            int grow = solve(
                s,
                i,
                j + 1,
                dp,
                k
            );

            int slide = solve(
                s,
                i + 1,
                j + 1,
                dp,
                k
            );

            ans = Math.max(grow, slide);
        }

        return dp[i][j] = ans;
    }


    public int maxPalindromes(String s, int k) {

        int n = s.length();

        vis = new boolean[n][n];

        // -------------------------
        // Palindrome DP
        // -------------------------

        for (int len = 1; len <= n; len++) {

            for (int i = 0; i + len - 1 < n; i++) {

                int j = i + len - 1;

                if (len == 1) {

                    vis[i][j] = true;

                } else if (len == 2) {

                    vis[i][j] =
                        s.charAt(i) == s.charAt(j);

                } else {

                    vis[i][j] =
                        s.charAt(i) == s.charAt(j)
                        && vis[i + 1][j - 1];
                }
            }
        }

        int[][] dp = new int[n][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(s, 0, k - 1, dp, k);
    }
}