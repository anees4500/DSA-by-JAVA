class Solution {

    public void dfs(List<List<Integer>> adj , int curr, boolean vis[]){
        vis[curr] = true;

        for(int i : adj.get(curr)){
            if(!vis[i]){
                dfs(adj,i,vis);
            }
            
        }
        

    }
    public int findCircleNum(int[][] isConnected) {


        List<List<Integer>> adj = new ArrayList<>();

        for(int i  = 0 ; i<isConnected.length; i++){
            adj.add(new ArrayList<>());
        }

        int n = isConnected.length;

        boolean vis[] = new boolean[n];



        for(int i = 0; i<isConnected.length; i++){
            int[] edge = isConnected[i];

            for(int j = 0; j<edge.length; j++){
                if( i!=j &&  isConnected[i][j]==1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        int count = 0;

        for(int i = 0; i<n ; i++){
            if(!vis[i]){
                dfs(adj,i,vis);
                count++;
            }
            
        }

        return count;
    }
}