class Solution {
    public int lengthOfLongestSubstring(String s) {

        StringBuilder sb = new StringBuilder();
        int ans = 0;

        for (int j = 0; j < s.length(); j++) {

            while (sb.indexOf(String.valueOf(s.charAt(j))) != -1) {
                sb.deleteCharAt(0);
            }

            sb.append(s.charAt(j));
            ans = Math.max(ans, sb.length());
        }

        return ans;
    }
}