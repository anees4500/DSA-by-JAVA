class Solution {

    int[] ans ;
    boolean vis[][];



    public void help(char[][] grid, int i , int j){

        
        if(vis[i][j]){
            return;
        }

        char c = grid[i][j];

        ans[0] = i;
        ans[1] = j;

        vis[i][j] = true;

        if(c=='R' && j+1<grid[0].length){
            
            help(grid,i,j+1);
            return;
        }
        if(c=='L' && j-1>=0){
             
            help(grid,i,j-1);
            return ;
        }
        if(c=='U' && i-1>=0){
            
            help(grid,i-1,j);
            return;
        }
        if(c=='D' && i+1<grid.length){ 
             
         
            help(grid,i+1 ,j);
            return;
        }

        
    }
    public int[] lastVisitedCell(char[][] grid) {
        
        ans =  new int[2];

        vis = new boolean[grid.length][grid[0].length];


        help(grid,0,0);

        return ans;


    }
}