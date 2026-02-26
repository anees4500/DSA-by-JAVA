class Solution {

    public class Pair{
        int max ;
        int i;
        int j;

        Pair(int m , int r,int c){
            this.max = m;
            this.i = r;
            this.j = c;
        }
    }
    public int swimInWater(int[][] grid) {
        

        int n = grid.length;
        int m = grid[0].length;

        boolean vis[][] = new boolean[n][m];

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.max-b.max);

        pq.offer(new Pair(grid[0][0], 0,0));

        while(!pq.isEmpty()){
            Pair curr = pq.poll();

            int lv = curr.max;
            int row = curr.i;
            int col = curr.j;

            if(vis[row][col]){
                continue;
            }

            

            if(row==n-1 && col==m-1){
                return lv;
            }

            vis[row][col] = true;

            // up

            if(row-1>=0 && !vis[row-1][col]){

                int newVal = Math.max(lv, grid[row-1][col]);

                pq.offer(new Pair(newVal, row-1,col));

            }

            // down

            if(row+1<n && !vis[row+1][col]){

                int newVal = Math.max(lv, grid[row+1][col]);

                pq.offer( new Pair(newVal, row+1,col));

            }

            // left

            if(col-1>=0 && !vis[row][col-1]){

                int newVal = Math.max(lv, grid[row][col-1]);

                pq.offer(new Pair(newVal, row,col-1));

            }

            // right

            if(col+1< m && !vis[row][col+1]){

                int newVal = Math.max(lv, grid[row][col+1]);

                pq.offer(new Pair(newVal, row,col+1));

            }


        }

        return 0;
    }
}