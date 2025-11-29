class Solution {
    private long dfsCountComponents(int u, int parent, List<List<Integer>> adj, int[] values, int k, int[] compCount, boolean[] vis) {
        vis[u] = true;
        long sum = values[u];

        for (int v : adj.get(u)) {
            if (v == parent) continue;
            if (!vis[v]) {
                sum += dfsCountComponents(v, u, adj, values, k, compCount, vis);
            }
        }

        if (sum % k == 0) {
            compCount[0]++;   // count this divisible component
            return 0L;       // cut it off for the parent
        }
        return sum;
    }

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        boolean[] vis = new boolean[n];
        int[] compCount = new int[1];

        for (int i = 0; i < n; i++) {
            if (!vis[i]) dfsCountComponents(i, -1, adj, values, k, compCount, vis);
        }

        return compCount[0];
    }
}
