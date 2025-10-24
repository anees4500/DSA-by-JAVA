 class Solution {

    public void dfs(char[][] grid, int i , int j, boolean[][] vis){
        vis[i][j] = true; // mark current cell

        // up
        if(i-1 >= 0 && grid[i-1][j] == '1' && !vis[i-1][j]){
            dfs(grid,i-1,j,vis);
        }
        // down
        if(i+1 < grid.length && grid[i+1][j] == '1' && !vis[i+1][j]){
            dfs(grid,i+1,j,vis);
        }
        // left
        if(j-1 >= 0 && grid[i][j-1] == '1' && !vis[i][j-1]){
            dfs(grid,i,j-1, vis);
        }
        // right
        if(j+1 < grid[0].length && grid[i][j+1] == '1' && !vis[i][j+1]){
            dfs(grid,i,j+1, vis);
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int count = 0;
        boolean[][] vis = new boolean[n][m];

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(!vis[i][j]  &&  grid[i][j] == '1'){
                    count++;
                    dfs(grid,i,j,vis);
                }
            }
        }

        return count;
    }
}
