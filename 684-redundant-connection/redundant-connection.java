class Solution {

    // DFS to check reachability
    public boolean dfs(List<List<Integer>> adj, boolean[] vis, int src, int target) {
        if (src == target) return true;

        vis[src] = true;

        for(int ne : adj.get(src)) {
            if(!vis[ne]){
                if(dfs(adj, vis, ne, target)) return true;
            }
        }
        return false;
    }

    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];

            boolean[] vis = new boolean[n + 1];

            if (!adj.get(u).isEmpty() && dfs(adj, vis, u, v)) {
                return e;
            }

            adj.get(u).add(v);
            adj.get(v).add(u);
        }



        return new int[0];
    }
}