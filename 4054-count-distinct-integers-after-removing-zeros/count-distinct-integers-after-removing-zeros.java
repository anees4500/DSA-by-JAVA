class Solution {
    /**
     * Counts the number of positive integers x, such that 1 <= x <= n,
     * where all digits of x are in the set {1, 2, ..., 9}.
     * This is an efficient O(log n) solution.
     * * @param n The upper bound.
     * @return The count of valid numbers.
     */
    public long countDistinct(long n) {
        // Get the number of digits in n
        String s = Long.toString(n);
        int digits = s.length();
        long ans = 0;

        // Part 1: Count all valid numbers with fewer digits than n
        // For a length d, there are 9^d valid numbers.
        long pow = 9;
        for (int d = 1; d < digits; d++) {
            ans += pow;
            pow *= 9; // pow now holds 9^(d+1) for the next iteration
        }

        // Part 2: Count valid numbers with the same length as n, up to n
        ans += countUpto(s);

        return ans;
    }

    /**
     * Counts numbers <= s using digits 1–9 only, having the same length as s.
     * Uses a digit-by-digit approach.
     * * @param s The string representation of n.
     * @return The count of valid numbers <= s.
     */
    private long countUpto(String s) {
        int len = s.length();
        long total = 0;

        for (int i = 0; i < len; i++) {
            int digit = s.charAt(i) - '0';

            // If the current digit of n is 0, any number formed with the 
            // current prefix is invalid (e.g., if n=105, 10... is invalid). 
            // We stop and return the count calculated so far.
            if (digit == 0) {
                return total;
            }

            // Count numbers that are strictly smaller than the prefix of s 
            // up to this point. For the current position i, we can place 
            // digits 1 to (digit - 1).
            // (digit - 1) choices for the current position.
            // 9^(remaining positions) choices for the rest.
            total += (digit - 1) * pow9(len - i - 1);
        }
        
        // If the loop completes, it means n itself contains only non-zero digits 
        // and is therefore a valid number, so we include it.
        return total + 1; 
    }

    /**
     * Helper function to calculate 9^x.
     */
    private long pow9(int x) {
        long r = 1;
        while (x-- > 0) {
            r *= 9;
        }
        return r;
    }
}