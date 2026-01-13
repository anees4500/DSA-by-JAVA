class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public void dfs(List<List<Integer>> adj, int curr, List<Integer> path) {

        path.add(curr);

        if (curr == adj.size() - 1) {
            ans.add(new ArrayList<>(path));
            path.remove(path.size() - 1); // BACKTRACK
            return;
        }

        for (int next : adj.get(curr)) {
            dfs(adj, next, path);
        }

        path.remove(path.size() - 1); // BACKTRACK
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < graph.length; i++) {
            for (int v : graph[i]) {
                adj.get(i).add(v);
            }
        }

        dfs(adj, 0, new ArrayList<>());
        return ans;
    }
}
