 class Solution {
    public int countPaths(int n, int[][] roads) {

        List<int[]> graph[] = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int[] r : roads) {
            graph[r[0]].add(new int[]{r[1], r[2]});
            graph[r[1]].add(new int[]{r[0], r[2]});
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        long[] ways = new long[n];
        int mod = (int)1e9+7;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        dist[0] = 0;
        ways[0] = 1;
        pq.add(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] top = pq.poll();
            long d = top[0];
            int node = (int)top[1];

            if (d > dist[node]) continue;

            for (int[] e : graph[node]) {
                int nei = e[0];
                long w = e[1];

                long nd = d + w;

                if (nd < dist[nei]) {
                    dist[nei] = nd;
                    ways[nei] = ways[node];
                    pq.add(new long[]{nd, nei});
                } 
                else if (nd == dist[nei]) {
                    ways[nei] = (ways[nei] + ways[node]) % mod;
                }
            }
        }

        return (int)ways[n-1];
    }
}
