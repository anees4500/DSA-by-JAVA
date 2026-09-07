class Solution {

    static final int MOD = 1_000_000_007;

    public int distinctSubseqII(String s) {
        long dp[] = new long[26];

        long total = 0;

        for(int i = 0; i<s.length(); i++){

            int idx = s.charAt(i) - 'a';

            long loEnd = (total +  1) % MOD;

            total = (total + loEnd - dp[idx] + MOD ) % MOD;
            dp[idx] = loEnd;
        }

        return (int)total;
    }
}