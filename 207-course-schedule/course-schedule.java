class Solution {

    public boolean dfs(int src , List<List<Integer>> adj, boolean vis[], boolean stack[]){
        vis[src] = true;
        stack[src] = true;
        for(int i : adj.get(src)){
            if(!vis[i]){
                if(dfs(i,adj,vis,stack)) return true;
            }
            else if(stack[i]){
                return true;    // cycle found
            }
        }
        stack[src] = false;
        return false; 
    }
 
    
    public boolean canFinish(int numC, int[][] pre) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i<numC; i++){
            adj.add(new ArrayList<>());
        }

        for(int ed[] : pre){
            int s = ed[0];
            int d = ed[1];

            adj.get(d).add(s);
        }
        boolean vis[] = new boolean[numC];

        boolean stack[] = new boolean[numC];

        for(int i = 0; i<numC; i++){
            if(!vis[i]){
                if(dfs(i,adj,vis, stack)) return false;
            }
        }
        return true;
    }
}