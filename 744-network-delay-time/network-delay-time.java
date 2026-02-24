class Solution {

    public static class Pair{

        int src ;
        int w;

        Pair(int src,int w){
            this.src=src;
            this.w = w;
        }

    }

    public int networkDelayTime(int[][] times, int n, int k) {
        

        List<List<int[]>> adjList = new ArrayList<>();

        for(int i =0; i<=n; i++){
            adjList.add(new ArrayList<>());
        }



        for(int e[]  : times){
            int src = e[0];
            int des = e[1];
            int w = e[2];
            adjList.get(src).add(new int[]{des,w});
        }

        int dest[] = new int[n+1];

        Arrays.fill(dest,Integer.MAX_VALUE);

        dest[0] = -1;

        dest[k] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.w-b.w);



        pq.offer(new Pair(k,0));


        while(!pq.isEmpty()){
            Pair curr = pq.poll();

            int s = curr.src;

            for(int i[] : adjList.get(s)){
                int des = i[0];
                int wei = i[1];

                if(wei+ dest[s]<dest[des]){
                   dest[des] = wei+dest[s]; 
                   pq.offer(new Pair(des,dest[des]));
                }

            }
        }

        int max = Integer.MIN_VALUE;


        for(int i : dest ){
            max = Math.max(max,i);
        }

        if(max==Integer.MAX_VALUE){
            return -1;
        }

        return max;



    }
}