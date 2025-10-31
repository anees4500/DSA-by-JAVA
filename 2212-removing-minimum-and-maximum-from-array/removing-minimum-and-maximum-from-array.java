 class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        int minIdx = 0, maxIdx = 0;

        // find indices of min and max
        for (int i = 0; i < n; i++) {
            if (nums[i] < minVal) {
                minVal = nums[i];
                minIdx = i;
            }
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                maxIdx = i;
            }
        }

        // Option 1: remove from front both elements
        int front = Math.max(minIdx, maxIdx) + 1;

        // Option 2: remove from back both elements
        int back = n - Math.min(minIdx, maxIdx);

        // Option 3: remove one from front, one from back
        int both = Math.min(minIdx + 1 + (n - maxIdx),
                            maxIdx + 1 + (n - minIdx));

        // Minimum of all 3
        return Math.min(front, Math.min(back, both));
    }
}
