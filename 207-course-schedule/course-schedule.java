 
import java.util.*;

class Solution {

    int[] vis;

    public boolean dfs(List<List<Integer>> adj, int src) {

        // Node is currently in the recursion stack:
        // a back edge means a cycle exists.
        if (vis[src] == 2) {
            return true;
        }

        // Node has already been completely processed.
        if (vis[src] == 1) {
            return false;
        }

        vis[src] = 2;

        for (int nei : adj.get(src)) {

            if (dfs(adj, nei)) {
                return true;
            }
        }

        // Mark node as completely processed.
        vis[src] = 1;

        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();
        vis = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            int course = edge[0];
            int prerequisite = edge[1];

            adj.get(course).add(prerequisite);
        }

        for (int i = 0; i < numCourses; i++) {
            if (vis[i] == 0 && dfs(adj, i)) {
                return false;
            }
        }

        return true;
    }
}
