class Solution {
    public int lengthOfLongestSubstring(String s) {
        int dp[] = new int[306];

        int i = 0;
        int j = 0;

        int ans = 0;

        while(j<s.length()){

            char ch = s.charAt(j);

            while( i<s.length() && dp[ch]!=0){

                dp[(int)s.charAt(i)]--;
                
                i++;
              
            }

            ans = Math.max(ans, j-i+1);

            dp[(int)ch]++;
            j++;
             
        }

        return ans;


    }
}