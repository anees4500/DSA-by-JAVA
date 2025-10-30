 class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits; // done, no carry
            }
            digits[i] = 0; // carry over
        }

        // If all digits were 9 → new array needed
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }
}
