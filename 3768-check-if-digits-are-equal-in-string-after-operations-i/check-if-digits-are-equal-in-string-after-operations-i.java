 class Solution {
    public boolean hasSameDigits(String s) {

        StringBuilder sb = new StringBuilder(s);

        while (sb.length() > 2) {
            String temp = sb.toString();  // save current version
            sb.setLength(0); // clear it

            for (int i = 1; i < temp.length(); i++) {
                int d1 = temp.charAt(i - 1) - '0';
                int d2 = temp.charAt(i) - '0';
                sb.append((d1 + d2) % 10);
            }
        }

        // now sb has length 2
        return sb.charAt(0) == sb.charAt(1);
    }
}
