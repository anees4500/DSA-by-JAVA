class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;

        if (grid[0][0] != 0 || grid[n-1][n-1] != 0)
            return -1;

        Queue<int[]> qu = new LinkedList<>();
        boolean[][] vis = new boolean[n][n];

        int[][] dirs = {
            {1,1},{1,0},{0,1},{-1,-1},{-1,1},{1,-1},{-1,0},{0,-1}
        };

        qu.add(new int[]{0,0,1});
        vis[0][0] = true;

        while (!qu.isEmpty()) {

            int[] curr = qu.remove();
            int i = curr[0];
            int j = curr[1];
            int step = curr[2];

            if (i == n - 1 && j == n - 1) {
                return step;
            }

            for (int[] it : dirs) {

                int ni = it[0] + i;
                int nj = it[1] + j;

                if (ni >= 0 && nj >= 0 && ni < n && nj < n &&
                    !vis[ni][nj] && grid[ni][nj] == 0) {

                    vis[ni][nj] = true;
                    qu.add(new int[]{ni, nj, step + 1});
                }
            }
        }

        return -1;
    }
}
