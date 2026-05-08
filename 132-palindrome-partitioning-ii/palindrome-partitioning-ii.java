class Solution {

    int dp[];

    // palindrome check
    public boolean isPalindrome(String s, int i, int j) {

        while (i < j) {

            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    // recursive function
    public int solve(String s, int i) {

        // whole string processed
        if (i == s.length()) {
            return 0;
        }

        // already computed
        if (dp[i] != -1) {
            return dp[i];
        }

        int min = Integer.MAX_VALUE;

        // try every partition
        for (int j = i; j < s.length(); j++) {

            // if substring palindrome
            if (isPalindrome(s, i, j)) {

                // recursive answer
                int cuts = 1 + solve(s, j + 1);

                min = Math.min(min, cuts);
            }
        }

        return dp[i] = min;
    }

    public int minCut(String s) {

        int n = s.length();

        dp = new int[n];

        Arrays.fill(dp, -1);

        // subtract 1 because partitions = cuts + 1
        return solve(s, 0) - 1;
    }
}