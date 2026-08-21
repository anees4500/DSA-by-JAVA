class Solution {

    long lcm(long a, long b, long limit) {
        long g = gcd(a, b);

        // avoid overflow
        if (a / g > limit / b) {
            return limit + 1;
        }

        return (a / g) * b;
    }

    long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    long count(long x, int[] coins) {

        int n = coins.length;
        long ans = 0;

        // Inclusion-Exclusion
        for (int mask = 1; mask < (1 << n); mask++) {

            long currLcm = 1;
            int bits = 0;
            boolean valid = true;

            for (int i = 0; i < n; i++) {

                if ((mask & (1 << i)) != 0) {

                    bits++;

                    currLcm = lcm(currLcm, coins[i], x);

                    if (currLcm > x) {
                        valid = false;
                        break;
                    }
                }
            }

            if (!valid) continue;

            long contribution = x / currLcm;

            if (bits % 2 == 1) {
                ans += contribution;
            } else {
                ans -= contribution;
            }
        }

        return ans;
    }

    public long findKthSmallest(int[] coins, int k) {

        long low = 1;

        long minCoin = Integer.MAX_VALUE;

        for (int coin : coins) {
            minCoin = Math.min(minCoin, coin);
        }

        long high = minCoin * (long) k;

        while (low < high) {

            long mid = low + (high - low) / 2;

            if (count(mid, coins) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}