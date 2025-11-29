class Solution {

    int target;
    int count = 0;

    public int dfs(List<List<Integer>> adj, int[] nums, int parent, int curr) {

        long sum = nums[curr];

        for (int child : adj.get(curr)) {
            if (child != parent) {
                sum += dfs(adj, nums, curr, child);
            }
        }

        if (sum == target) {
            count++;
            return 0; 
        }

        return (int) sum;
    }

    public int componentValue(int[] nums, int[][] edges) {

        int n = nums.length;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        long total = 0;
        for (int x : nums) total += x;

        // Try maximum k first
        for (int k = n; k >= 1; k--) {

            if (total % k != 0) continue; // only possible targets

            target = (int)(total / k);

            count = 0;

            dfs(adj, nums, -1, 0);

            if (count == k)
                return k - 1;       // maximum edges deleted
        }

        return 0;
    }
}
