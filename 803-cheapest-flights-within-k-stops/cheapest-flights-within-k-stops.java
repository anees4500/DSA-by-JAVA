class Solution {
    class Pair {
        int node, cost, stops;
        Pair(int node, int cost, int stops) {
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] f : flights)
            adj.computeIfAbsent(f[0], x -> new ArrayList<>()).add(new int[]{f[1], f[2]});

        // min cost per node per stops
        int[][] dist = new int[n][k + 2];
        for (int[] d : dist) Arrays.fill(d, Integer.MAX_VALUE);
        dist[src][k + 1] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.add(new Pair(src, 0, k + 1));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int u = p.node, cost = p.cost, stops = p.stops;
            if (u == dst) return cost;
            if (stops == 0) continue;

            for (int[] nei : adj.getOrDefault(u, new ArrayList<>())) {
                int v = nei[0], w = nei[1];
                if (cost + w < dist[v][stops - 1]) {
                    dist[v][stops - 1] = cost + w;
                    pq.add(new Pair(v, dist[v][stops - 1], stops - 1));
                }
            }
        }
        return -1;
    }
}
