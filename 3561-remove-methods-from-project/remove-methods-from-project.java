class Solution {

    public void dfs(List<List<Integer>> adj, int node, boolean[] vis) {
        vis[node] = true;

        for (int nei : adj.get(node)) {
            if (!vis[nei]) {
                dfs(adj, nei, vis);
            }
        }
    }

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : invocations) {
            adj.get(edge[0]).add(edge[1]);
        }

        // Find all suspicious methods
        boolean[] vis = new boolean[n];
        dfs(adj, k, vis);

        // Check if any safe method calls a suspicious method
        for (int[] edge : invocations) {
            int src = edge[0];
            int dest = edge[1];

            if (!vis[src] && vis[dest]) {
                List<Integer> ans = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    ans.add(i);
                }
                return ans;
            }
        }

        // Return only remaining (safe) methods
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                ans.add(i);
            }
        }

        return ans;
    }
}