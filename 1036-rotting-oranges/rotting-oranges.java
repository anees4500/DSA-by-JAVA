 import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;

        boolean[][] vis = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();

        // Step 1: Push all rotten oranges
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j, 0});  // ✅ in Java, use offer() or add()
                    vis[i][j] = true;
                }
            }
        }

        // Step 2: BFS traversal
        while (!q.isEmpty()) {
            int[] a = q.poll();
            int i = a[0];
            int j = a[1];
            int time = a[2];

            ans = Math.max(ans, time); // ✅ use max (you had min earlier, wrong direction)

            // check up
            if (i - 1 >= 0 && !vis[i - 1][j] && grid[i - 1][j] == 1) {
                q.offer(new int[]{i - 1, j, time + 1});
                vis[i - 1][j] = true;
            }
            // check down
            if (i + 1 < n && !vis[i + 1][j] && grid[i + 1][j] == 1) {
                q.offer(new int[]{i + 1, j, time + 1});
                vis[i + 1][j] = true;
            }
            // check left
            if (j - 1 >= 0 && !vis[i][j - 1] && grid[i][j - 1] == 1) {
                q.offer(new int[]{i, j - 1, time + 1});
                vis[i][j - 1] = true;
            }
            // check right
            if (j + 1 < m && !vis[i][j + 1] && grid[i][j + 1] == 1) {
                q.offer(new int[]{i, j + 1, time + 1});
                vis[i][j + 1] = true;
            }
        }

        // Step 3: Check for any unvisited fresh orange
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    return -1;
                }
            }
        }

        return ans;
    }
}
