class Solution {
    public String shortestBeautifulSubstring(String s, int k) {

        int left = 0;
        int count = 0;

        String ans = "";

        for (int right = 0; right < s.length(); right++) {

            if (s.charAt(right) == '1') {
                count++;
            }

            // More than k ones
            while (count > k) {
                if (s.charAt(left) == '1') {
                    count--;
                }
                left++;
            }

            // Exactly k ones
            while (count == k) {

                String curr = s.substring(left, right + 1);

                // Remove leading zeros if possible
                if (curr.charAt(0) == '0') {
                    left++;
                    continue;
                }

                // Compare with answer
                if (ans.equals("") ||
                    curr.length() < ans.length() ||
                    (curr.length() == ans.length() &&
                     curr.compareTo(ans) < 0)) {

                    ans = curr;
                }

                // Try making window smaller
                if (s.charAt(left) == '1') {
                    count--;
                }

                left++;
            }
        }

        return ans;
    }
}