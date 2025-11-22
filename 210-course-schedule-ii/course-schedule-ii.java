class Solution {

    public boolean dfs(int src , List<List<Integer>> adj, boolean vis[] , Stack<Integer> stack, boolean st[]){
        vis[src] = true;
        st[src] = true;
         


        for(int nxt : adj.get(src)){
            if(!vis[nxt]){
                if(dfs(nxt,adj,vis,stack,st)){
                    return true;
                }
            }
            if(st[nxt]){
                return true;
            }
        }

        stack.add(src);
        st[src] = false;
        return false;
    }


    public int[] findOrder(int numC, int[][] pre) {
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

        Stack<Integer> stack = new Stack<>();

        boolean st[] = new boolean[numC];

        for(int i = 0; i<numC; i++){
            if(!vis[i]){
                if(dfs(i,adj,vis,stack,st)){
                    return new int[0];
                }
            }
        }
         
        int ans[] = new int[stack.size()];

        int idx = 0;


        for(int i = 0; i<ans.length; i++){
            ans[idx++] = stack.pop();
        }

        return ans;

         

        
    }
}