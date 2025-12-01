class Solution {

    // int height;   // (unused but kept same as your format)

    // public void dfs(List<List<Integer>> adj, int curr, int parent, int depth) {
    //     height = Math.max(height, depth);
    //     for (int neigh : adj.get(curr)) {
    //         if (neigh != parent) {
    //             dfs(adj, neigh, curr, depth + 1);
    //         }
    //     }
    // }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        // build graph and degree map
        for (int[] ed : edges) {
            adj.get(ed[0]).add(ed[1]);
            adj.get(ed[1]).add(ed[0]);
            map.put(ed[0], map.getOrDefault(ed[0], 0) + 1);
            map.put(ed[1], map.getOrDefault(ed[1], 0) + 1);
        }

        // ensure all nodes exist in map
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(i, map.getOrDefault(i, 0));
        }

        // leaf trimming
        while (map.size() > 2) {

            List<Integer> leaves = new ArrayList<>();

            // collect current leaves
            for (int key : map.keySet()) {
                if (map.get(key) == 1) {
                    leaves.add(key);
                }
            }

            // remove leaves safely
            for (int leaf : leaves) {
                // mark removed
                map.put(leaf, 0);

                // reduce degree of neighbors
                for (int nei : adj.get(leaf)) {
                    if (map.containsKey(nei) && map.get(nei) > 0) {
                        map.put(nei, map.get(nei) - 1);
                    }
                }

                // now safe to remove leaf from map
                map.remove(leaf);
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int key : map.keySet()) {
            ans.add(key);
        }

        return ans;
    }
}
