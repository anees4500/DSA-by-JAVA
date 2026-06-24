import java.util.*;

class Solution {

    int[][] jobs;
    int[] dp;
    int[] starts;

    private int solve(int idx) {

        if (idx >= jobs.length) {
            return 0;
        }

        if (dp[idx] != -1) {
            return dp[idx];
        }

        // Find next non-overlapping job
        int nextIdx = lowerBound(jobs[idx][1]);

        int take = jobs[idx][2] + solve(nextIdx);
        int skip = solve(idx + 1);

        return dp[idx] = Math.max(take, skip);
    }

    private int lowerBound(int target) {

        int low = 0;
        int high = starts.length - 1;
        int ans = starts.length;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (starts[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        int n = startTime.length;

        jobs = new int[n][3];

        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }

        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));

        starts = new int[n];

        for (int i = 0; i < n; i++) {
            starts[i] = jobs[i][0];
        }

        dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(0);
    }
}