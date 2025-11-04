 import java.util.*;

class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            Map<Integer, Integer> freq = new HashMap<>();

            // frequency of current window
            for (int j = i; j < i + k; j++) {
                freq.put(nums[j], freq.getOrDefault(nums[j], 0) + 1);
            }

            // sort by (freq desc, val desc)
            List<int[]> list = new ArrayList<>();
            for (var e : freq.entrySet()) {
                list.add(new int[]{e.getKey(), e.getValue()});
            }
            Collections.sort(list, (a, b) -> {
                if (b[1] != a[1]) return b[1] - a[1];
                return b[0] - a[0];
            });

            int sum = 0;
            for (int t = 0; t < Math.min(x, list.size()); t++) {
                sum += list.get(t)[0] * list.get(t)[1];  // multiply value * freq
            }

            ans[i] = sum;
        }

        return ans;
    }
}
