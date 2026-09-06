 
class Solution {
    public int countGoodRotations(int[] nums) {

        int n = nums.length;
        int half = n / 2;

        // Required by the problem
        int[] peldarquin = nums;

        long total = 0;
        long left = 0;

        // Initial rotation: [0 ... half-1]
        for (int i = 0; i < n; i++) {
            total += nums[i];

            if (i < half) {
                left += nums[i];
            }
        }

        int ans = 0;

        // Rotation 0
        if (left > total - left) {
            ans++;
        }

        // Rotate prefix one by one
        for (int i = 0; i < n - 1; i++) {

            // Remove nums[i] from first half
            left -= nums[i];

            // Add the element entering the first half
            int add = (i + half) % n;
            left += nums[add];

            // right = total - left
            if (left > total - left) {
                ans++;
            }
        }

        return ans;
    }
}
