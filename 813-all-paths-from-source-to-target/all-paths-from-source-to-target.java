class Solution {
    public void helper(List<List<Integer>> adj, List<List<Integer>> ans,List<Integer> list , int src , int des, boolean vis[]){

        list.add(src);
        if(src==des){
            ans.add(new ArrayList<>(list));
            
            return;
        }

        

        for(int i : adj.get(src)){

            if(!vis[i]){
                vis[i] = true;
                helper(adj,ans,list, i, des,vis);
                vis[i] = false;
                list.remove(list.size()-1);

            }

        }
         

    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();

        boolean vis[] = new boolean[graph.length];

        for(int i = 0; i<graph.length; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i<graph.length ; i++){
            int ed[] = graph[i];

            for(int j = 0 ; j<ed.length; j++){
                adj.get(i).add(ed[j]);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        helper(adj,ans ,list, 0 , graph.length-1, vis);

        return ans;


    }
}