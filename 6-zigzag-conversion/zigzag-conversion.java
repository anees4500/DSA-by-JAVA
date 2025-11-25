class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        
        StringBuilder sb = new StringBuilder();
        int cycleLen = 2 * numRows - 2;

        for (int row = 0; row < numRows; row++) {
            for (int j = row; j < s.length(); j += cycleLen) {
                sb.append(s.charAt(j));

                int diag = j + cycleLen - 2 * row;

                // middle rows ke diagonal characters
                if (row != 0 && row != numRows - 1 && diag < s.length()) {
                    sb.append(s.charAt(diag));
                }
            }
        }
        return sb.toString();
    }
}
