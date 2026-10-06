class Solution {

    public void dfs(char[][] grid, int i , int j , boolean vis[][]){

        vis[i][j] = true;
        
        // left

        if(j-1>=0 && !vis[i][j-1] && grid[i][j-1]=='1'){
            dfs(grid,i , j-1, vis);
        }

        // right

        if(j+1 < grid[0].length && !vis[i][j+1] && grid[i][j+1]=='1'){
            dfs(grid,i , j+1, vis);
        }

        // up
        
        if(i-1 >=0 && !vis[i-1][j] && grid[i-1][j]=='1'){
            dfs(grid,i-1 , j, vis);
        }
 
        // down

        if(i+1<grid.length && !vis[i+1][j] && grid[i+1][j]=='1'){
            dfs(grid,i+1, j, vis);
        }
    }

    public int numIslands(char[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;

        int ans = 0;

        boolean vis[][] = new boolean[n][m];

        for(int i = 0 ; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j]=='1' && !vis[i][j]){
                    ans++;
                    dfs(grid, i, j, vis);
                }
            }
        }

        return ans;
    }
}