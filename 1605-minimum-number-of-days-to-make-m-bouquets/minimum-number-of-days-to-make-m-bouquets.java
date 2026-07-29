class Solution {

    public boolean canMake(int[] bloomDay, int m, int k, int day) {
        int bouquets = 0;
        int count = 0;

        for (int bloom : bloomDay) {

            if (bloom <= day) {
                count++;

                if (count == k) {
                    bouquets++;
                    count = 0; // flowers used
                }
            } else {
                count = 0; // adjacency breaks
            }
        }

        return bouquets >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {

        long totalFlowersNeeded = (long) m * k;
        if (totalFlowersNeeded > bloomDay.length)
            return -1;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int day : bloomDay) {
            low = Math.min(low, day);
            high = Math.max(high, day);
        }

        int ans = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canMake(bloomDay, m, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}