class Solution {

    public int help(String s, int i , int dp[]) {

        // reached end
        if(i == s.length()) {
            return 1;
        }

        if(dp[i]!=-1){
            return dp[i];
        }

        // starts with 0 -> invalid
        if(s.charAt(i) == '0') {
            return 0;
        }

        // take one digit
        int ans = help(s, i + 1 ,dp);

        // take two digits
        if(i + 1 < s.length()) {

            int num = Integer.parseInt(s.substring(i, i + 2));

            if(num >= 10 && num <= 26) {
                ans += help(s, i + 2 ,dp);
            }
        }

        return dp[i] = ans;
    }

    public int numDecodings(String s) {

        int dp[] = new int[s.length()];

        Arrays.fill(dp , -1);

        return help(s, 0 , dp);
    }
}