 class Solution {
    public int reverse(int x) {
        boolean isNegative = x < 0;
        long num = Math.abs((long)x); // ✅ cast to long BEFORE abs()

        StringBuilder sb = new StringBuilder(String.valueOf(num));
        sb.reverse();

        long reversed = Long.parseLong(sb.toString());
        if (isNegative) reversed = -reversed;

        if (reversed < Integer.MIN_VALUE || reversed > Integer.MAX_VALUE) {
            return 0; // ✅ handle overflow
        }

        return (int) reversed;
    }
}
