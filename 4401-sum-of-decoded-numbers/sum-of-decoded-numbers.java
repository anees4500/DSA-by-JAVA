 class Solution {

    static final long MOD = 1_000_000_007;

    public int sumDecoded(long[] nums) {

        long ans = 0;

        for (long num : nums) {

            int width = (int) (num % 10);
            long d = num / 10;

            // Count digits of d
            int digits = 0;
            long temp = d;

            while (temp > 0) {
                temp /= 10;
                digits++;
            }

            long real = d;
            long y = 0;
            long place = 1;

            // Extract exponent
            while (digits - width > 0) {

                y += (real % 10) * place;

                real /= 10;
                place *= 10;

                digits--;
            }

            long x = real;

            ans = (ans + power(x, y)) % MOD;
        }

        return (int) ans;
    }

    static long power(long x, long y) {

        long result = 1;

        x %= MOD;

        while (y > 0) {

            if ((y & 1) == 1) {
                result = (result * x) % MOD;
            }

            x = (x * x) % MOD;
            y >>= 1;
        }

        return result;
    }
}