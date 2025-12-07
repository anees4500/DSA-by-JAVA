 import java.util.*;

class Solution {
    public int countTrapezoids(int[][] points) {
        final int MOD = 1_000_000_007;
        Map<Integer, Integer> yCount = new HashMap<>();

        // Count how many points exist on each y-coordinate
        for (int[] point : points) {
            int y = point[1];
            yCount.put(y, yCount.getOrDefault(y, 0) + 1);
        }

        long totalPairs = 0;
        long squareSum = 0;

        for (int count : yCount.values()) {
            if (count >= 2) {
                long pairs = ((long) count * (count - 1)) / 2;
                totalPairs = (totalPairs + pairs) % MOD;
                squareSum = (squareSum + (pairs * pairs) % MOD) % MOD;
            }
        }

        // Use (totalPairs^2 - squareSum) / 2
        long result = (totalPairs * totalPairs % MOD - squareSum + MOD) % MOD;
        result = result * modInverse(2, MOD) % MOD;

        return (int) result;
    }

    // Modular inverse using Fermat's Little Theorem
    private long modInverse(long a, int mod) {
        return pow(a, mod - 2, mod);
    }

    private long pow(long base, long exp, int mod) {
        long res = 1;
        base = base % mod;
        while (exp > 0) {
            if ((exp & 1) == 1)
                res = (res * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }
}
