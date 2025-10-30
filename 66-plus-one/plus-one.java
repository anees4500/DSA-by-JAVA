 class Solution {
    public int[] plusOne(int[] digits) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < digits.length; i++) {
            sb.append(digits[i]);
        }

        // Use BigInteger to handle large numbers safely
        java.math.BigInteger num = new java.math.BigInteger(sb.toString());
        num = num.add(java.math.BigInteger.ONE);

        String str = num.toString();

        int[] dig = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            dig[i] = str.charAt(i) - '0'; // ✅ convert char to int
        }

        return dig;
    }
}
