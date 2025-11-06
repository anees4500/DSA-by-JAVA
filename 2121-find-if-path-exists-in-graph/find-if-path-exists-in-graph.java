 import java.util.*;

class Solution {
    public boolean helper(List<List<Integer>> adj, int src, int des, boolean[] vis) {
        vis[src] = true;
        if (src == des) return true; // direct check

        for (int i : adj.get(src)) {
            if (!vis[i] && helper(adj, i, des, vis)) {
                return true;
            }
        }

        return false;
    }

    public boolean validPath(int n, int[][] edges, int src, int des) {
        boolean[] vis = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();

        //  Initialize adjacency list with n vertices
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        return helper(adj, src, des, vis);
    }
}
