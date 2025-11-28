 
class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;

        // prefix sum of size n+1
        long[] prefSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefSum[i + 1] = prefSum[i] + nums[i];
        }

        long result = Long.MIN_VALUE;

        // start index from 0 to k-1
        for (int start = 0; start < k; start++) {

            long currSum = Long.MIN_VALUE;
            int i = start;

            // while k-size window is valid
            while (i + k <= n) {

                int j = i + k; // end index EXCLUSIVE (prefix logic)

                // subarray sum = pref[j] - pref[i]
                long subSum = prefSum[j] - prefSum[i];

                // Kadane on k-blocks
                if (currSum < 0)
                    currSum = subSum;
                else
                    currSum += subSum;

                result = Math.max(result, currSum);

                i += k; // move next block
            }
        }

        return result;
    }
}
