 import java.util.*;

class Solution {

    public boolean dfs(int node, List<List<Integer>> adj, int[] vis, int[] pathVis) {
        vis[node] = 1;       // mark visited
        pathVis[node] = 1;   // mark current recursion path

        for (int it : adj.get(node)) {
            if (vis[it] == 0) {
                if (dfs(it, adj, vis, pathVis)) return true;  // cycle found
            } else if (pathVis[it] == 1) {
                return true;  // cycle found
            }
        }

        pathVis[node] = 0;  // backtrack
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        // Build adjacency list
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]); // edge: pre[1] → pre[0]
        }

        int[] vis = new int[numCourses];
        int[] pathVis = new int[numCourses];

        // Check each course
        for (int i = 0; i < numCourses; i++) {
            if (vis[i] == 0) {
                if (dfs(i, adj, vis, pathVis)) return false; // cycle = cannot finish
            }
        }

        return true; // no cycle → can finish all courses
    }
}
