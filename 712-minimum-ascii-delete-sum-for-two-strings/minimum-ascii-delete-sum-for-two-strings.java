class Solution {
public int minimumDeleteSum(String s1, String s2) {
int n = s1.length();
int m = s2.length();

    // dp[i][j] = max ASCII sum of LCS till s1[0..i-1] and s2[0..j-1]
    int[][] dp = new int[n+1][m+1];

    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= m; j++){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                dp[i][j] = dp[i-1][j-1] + s1.charAt(i-1);
            } else {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
    }

    int lcsSum = dp[n][m];

    // Total ASCII sum of s1 + s2
    int total = 0;
    for(char c : s1.toCharArray()) total += c;
    for(char c : s2.toCharArray()) total += c;

    return total - 2 * lcsSum;
}


}
