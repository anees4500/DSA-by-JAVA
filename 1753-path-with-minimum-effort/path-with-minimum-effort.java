class Solution {

    class Pair {
        int dif, r, c;

        Pair(int d, int r, int c) {
            this.dif = d;
            this.r = r;
            this.c = c;
        }
    }

    public int minimumEffortPath(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> a.dif - b.dif);

        pq.add(new Pair(0, 0, 0));

        while (!pq.isEmpty()) {

            Pair curr = pq.poll();

            int d = curr.dif;
            int cr = curr.r;
            int cc = curr.c;

            if (vis[cr][cc]) continue;
            vis[cr][cc] = true;

            if (cr == n - 1 && cc == m - 1) {
                return d;
            }

            // UP
            if (cr - 1 >= 0 && !vis[cr - 1][cc]) {
                int diff = Math.abs(grid[cr - 1][cc] - grid[cr][cc]);
                int nn = Math.max(d, diff);
                pq.add(new Pair(nn, cr - 1, cc));
            }

            // DOWN
            if (cr + 1 < n && !vis[cr + 1][cc]) {
                int diff = Math.abs(grid[cr + 1][cc] - grid[cr][cc]);
                int nn = Math.max(d, diff);
                pq.add(new Pair(nn, cr + 1, cc));
            }

            // LEFT
            if (cc - 1 >= 0 && !vis[cr][cc - 1]) {
                int diff = Math.abs(grid[cr][cc - 1] - grid[cr][cc]);
                int nn = Math.max(d, diff);
                pq.add(new Pair(nn, cr, cc - 1));
            }

            // RIGHT
            if (cc + 1 < m && !vis[cr][cc + 1]) {
                int diff = Math.abs(grid[cr][cc + 1] - grid[cr][cc]);
                int nn = Math.max(d, diff);
                pq.add(new Pair(nn, cr, cc + 1));
            }
        }

        return 0;
    }
}