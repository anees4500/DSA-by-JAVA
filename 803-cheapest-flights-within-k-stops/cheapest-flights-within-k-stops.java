class Solution {

    static class Pair {
        int node;
        int cost;
        int stops;

        Pair(int node, int cost, int stops) {
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public int findCheapestPrice(int n, int[][] flights,
                                 int src, int dst, int k) {

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] f : flights) {
            adj.get(f[0]).add(new int[]{f[1], f[2]});
        }

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> a.cost - b.cost);

        pq.offer(new Pair(src, 0, 0));

        int[] stopsArr = new int[n];
        Arrays.fill(stopsArr, Integer.MAX_VALUE);

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();

            if (curr.node == dst) return curr.cost;

            if (curr.stops > k || curr.stops > stopsArr[curr.node])
                continue;

            stopsArr[curr.node] = curr.stops;

            for (int[] nei : adj.get(curr.node)) {
                pq.offer(new Pair(
                        nei[0],
                        curr.cost + nei[1],
                        curr.stops + 1
                ));
            }
        }

        return -1;
    }
}