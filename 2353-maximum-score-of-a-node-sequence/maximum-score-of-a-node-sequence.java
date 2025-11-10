 class Solution {
    public int maximumScore(int[] scores, int[][] edges) {
        int n = scores.length;
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        // Precompute top 3 neighbors for each node
        List<Integer>[] topNeighbors = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> scores[x] - scores[y]);
            for (int nei : adj[i]) {
                pq.offer(nei);
                if (pq.size() > 3) pq.poll();
            }
            topNeighbors[i] = new ArrayList<>(pq);
        }

        int maxScore = -1;

        // Iterate over edges
        for (int[] e : edges) {
            int b = e[0], c = e[1];
            for (int a : topNeighbors[b]) {
                if (a == c) continue;
                for (int d : topNeighbors[c]) {
                    if (d == b || d == a) continue;
                    int sum = scores[a] + scores[b] + scores[c] + scores[d];
                    maxScore = Math.max(maxScore, sum);
                }
            }
            // also consider sequence in reverse b-c → c-b (same logic)
            for (int a : topNeighbors[c]) {
                if (a == b) continue;
                for (int d : topNeighbors[b]) {
                    if (d == c || d == a) continue;
                    int sum = scores[a] + scores[b] + scores[c] + scores[d];
                    maxScore = Math.max(maxScore, sum);
                }
            }
        }

        return maxScore;
    }
}
