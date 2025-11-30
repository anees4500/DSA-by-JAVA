class Solution {

    List<List<Integer>> adj;
    int[] subtree;
    int[] ans;
    int n;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {

        this.n = n;
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        subtree = new int[n];
        ans = new int[n];

        // boolean[] vis = new boolean[n];

        // 1st DFS: compute subtree sizes + ans[0]
        dfs1(0, -1);

        // 2nd DFS: re-root DP
        dfs2(0, -1);

        return ans;
    }

    // Subtree DP
    public void dfs1(int curr, int parent) {

        subtree[curr] = 1;  // include itself

        for (int nxt : adj.get(curr)) {
            if (nxt != parent) {

                dfs1(nxt, curr);
                subtree[curr] += subtree[nxt];
                ans[0] += subtree[nxt];  // distance contribution
            }
        }
    }

    // Reroot DP
    public void dfs2(int curr, int parent) {

        for (int nxt : adj.get(curr)) {
            if (nxt != parent) {
                // Formula:
                // ans[nxt] = ans[curr] - subtree[nxt] + (n - subtree[nxt])
                ans[nxt] = ans[curr] - subtree[nxt] + (n - subtree[nxt]);
                dfs2(nxt, curr);
            }
        }
    }
}
