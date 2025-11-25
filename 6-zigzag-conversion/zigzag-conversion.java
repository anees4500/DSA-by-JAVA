class Solution {
    public String convert(String s, int numRows) {

        // Special cases
        if (numRows == 1) return s;

        // Special handling for numRows = 2
        if (numRows == 2) {
            StringBuilder sb = new StringBuilder();

            // First row
            for (int i = 0; i < s.length(); i += 2)
                sb.append(s.charAt(i));

            // Second row
            for (int i = 1; i < s.length(); i += 2)
                sb.append(s.charAt(i));

            return sb.toString();
        }

        // Normal case for numRows >= 3
        int cycle = 2 * numRows - 2;
        int cols = (s.length() / cycle + 1) * (numRows - 1);

        char[][] dp = new char[numRows][cols];

        // Fill matrix with placeholder
        for (int i = 0; i < numRows; i++) {
            java.util.Arrays.fill(dp[i], '=');
        }

        int i = 0, j = 0, k = 0;
        boolean down = true;

        while (k < s.length()) {
            dp[i][j] = s.charAt(k++);

            if (down) {
                i++;
                if (i == numRows) {
                    i = numRows - 2;
                    j++;
                    down = false;
                }
            } else {
                i--;
                j++;
                if (i == 0) {
                    down = true;
                }
            }
        }

        // Build result
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < cols; c++) {
                if (dp[r][c] != '=') {
                    sb.append(dp[r][c]);
                }
            }
        }

        return sb.toString();
    }
}
