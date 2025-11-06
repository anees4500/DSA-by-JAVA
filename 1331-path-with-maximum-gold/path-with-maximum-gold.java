 class Solution {

    public int dfs(int[][] grid, int i, int j, boolean[][] vis) {
        vis[i][j] = true;
        int currGold = grid[i][j];
        int maxGold = 0;

        // top
        if (i > 0 && !vis[i - 1][j] && grid[i - 1][j] != 0)
            maxGold = Math.max(maxGold, dfs(grid, i - 1, j, vis));

        // bottom
        if (i < grid.length - 1 && !vis[i + 1][j] && grid[i + 1][j] != 0)
            maxGold = Math.max(maxGold, dfs(grid, i + 1, j, vis));

        // left
        if (j > 0 && !vis[i][j - 1] && grid[i][j - 1] != 0)
            maxGold = Math.max(maxGold, dfs(grid, i, j - 1, vis));

        // right
        if (j < grid[0].length - 1 && !vis[i][j + 1] && grid[i][j + 1] != 0)
            maxGold = Math.max(maxGold, dfs(grid, i, j + 1, vis));

        vis[i][j] = false; // backtrack
        return currGold + maxGold;
    }

    public int getMaximumGold(int[][] grid) {
        int fmax = 0;
        boolean[][] vis = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    fmax = Math.max(fmax, dfs(grid, i, j, vis));
                }
            }
        }
        return fmax;
    }
}
