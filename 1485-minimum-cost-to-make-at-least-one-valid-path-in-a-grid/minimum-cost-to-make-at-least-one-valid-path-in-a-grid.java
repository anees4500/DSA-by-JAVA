class Solution {
    public class Pair{

        int cost;
        int r ; 
        int c;

        Pair(int c , int s , int d){
            this.cost = c;
            this.r= s;
            this.c = d;
        }

    }


    public int minCost(int[][] grid) {
        int n = grid.length; 
        int m = grid[0].length;

        boolean vis[][] = new boolean[n][m];

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.cost-b.cost);

        pq.add(new Pair(0, 0, 0));

        while(!pq.isEmpty()){
            
            Pair curr = pq.poll();
            int cost = curr.cost;
            int row  = curr.r;
            int col = curr.c;

            if(row==n-1 && col==m-1){
                return cost;
            }


            if( vis[row][col]){
                continue;
            }

            vis[row][col] = true;
            
            // up 

            if(row-1>=0){
                if(!vis[row-1][col]){
                    if(grid[row][col]==4){
                        pq.add(new Pair(cost,row-1,col));
                    }
                    else{
                         pq.add(new Pair(cost+1,row-1,col));
                    }
                   
                }
            }

            // down

            if(row+1<n  && !vis[row+1][col] ){
                if(grid[row][col]==3){
                    pq.add(new Pair(cost,row+1,col));
                }
                else{
                    pq.add(new Pair(cost+1,row+1,col));
                }
                
            }

            // left

            if(col-1>=0 && !vis[row][col-1]){
                if(grid[row][col]==2){
                    pq.add(new Pair(cost,row,col-1));
                }
                else{
                    pq.add(new Pair(cost+1,row,col-1));
                }
            }

            // right

            if(col+1<m && !vis[row][col+1]){
                if(grid[row][col]==1){
                    pq.add(new Pair(cost,row,col+1));
                }
                else{
                    pq.add(new Pair(cost+1,row,col+1));
                }
            }

        }

        return -1;
        

    }
}