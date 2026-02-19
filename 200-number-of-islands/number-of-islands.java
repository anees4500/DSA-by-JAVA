class Solution {

    public void dfs(char[][] grid, int i , int j , boolean[][] vis){
        
        vis[i][j] = true;

        // left

        if(j-1>=0 && !vis[i][j-1]){
            if(grid[i][j-1]=='1'){
                dfs(grid,i,j-1,vis);
            }
            ;
        }

        // right

        if(j+1<grid[0].length && !vis[i][j+1] ){
            if(grid[i][j+1]=='1'){
                dfs(grid,i,j+1,vis);
            }
            
        }

        //up
        if(i-1>=0 && !vis[i-1][j]){
            if(grid[i-1][j]=='1'){
                dfs(grid,i-1,j , vis);
            }
            

        }

        // down
        if(i+1<grid.length && !vis[i+1][j]){
            if(grid[i+1][j]=='1'){
                dfs(grid,i+1,j,vis);
            }
        }


    }


    public int numIslands(char[][] grid) {
    
        boolean[][] vis = new boolean[grid.length][grid[0].length];

        int count = 0;

        for(int i  = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(!vis[i][j] && grid[i][j]=='1'){
                    dfs(grid,i, j,vis);
                    count++;
                }

            }
        }
        return count;


    }
}