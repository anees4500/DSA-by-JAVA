 import java.math.BigInteger;

class Solution {
    public String addBinary(String a, String b) {
        BigInteger s1 = new BigInteger(a, 2);
        BigInteger s2 = new BigInteger(b, 2);

        BigInteger sum = s1.add(s2);
        return sum.toString(2);  // Convert back to binary string
    }
}