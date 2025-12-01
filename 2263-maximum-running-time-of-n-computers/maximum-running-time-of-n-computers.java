 class Solution {
    public long maxRunTime(int n, int[] batteries) {

        long sum = 0;
        for (int b : batteries) sum += b;

        long low = 0, high = sum / n;

        while (low < high) {

            long mid = (low + high + 1) / 2;

            long total = 0;
            for (int b : batteries) {
                total += Math.min(b, mid);
            }

            if (total >= (long)n * mid) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }
}
