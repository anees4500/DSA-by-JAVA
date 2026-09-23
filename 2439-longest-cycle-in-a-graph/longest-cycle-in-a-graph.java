class Solution {
    public int longestCycle(int[] edges) {

        int n = edges.length;
        boolean[] visited = new boolean[n];
        int[] depth = new int[n];

        int ans = -1;

        for (int i = 0; i < n; i++) {

            if (visited[i]) continue;

            int node = i;
            int currentDepth = 0;

            while (node != -1 && !visited[node]) {

                visited[node] = true;
                depth[node] = currentDepth++;

                node = edges[node];
            }

            // node is already visited
            // Need to check whether it belongs to THIS traversal
            if (node != -1 && depth[node] >= 0) {
                ans = Math.max(ans, currentDepth - depth[node]);
            }

            // reset depth information for this traversal
            node = i;
            while (node != -1 && visited[node]) {
                if (depth[node] == -1) break;
                depth[node] = -1;
                node = edges[node];
            }
        }

        return ans;
    }
}