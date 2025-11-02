 class Solution {
    int countT = 0;

    // helper function to mark guarded cells in 4 straight directions
    public void count(int[][] area, int i, int j, boolean[][] vis) {
        int m = area.length;
        int n = area[0].length;

        // UP
        for (int x = i - 1; x >= 0; x--) {
            if (area[x][j] == 1 || area[x][j] == 2) break;
            if (!vis[x][j]) {
                vis[x][j] = true;
                countT++;
            }
        }

        // DOWN
        for (int x = i + 1; x < m; x++) {
            if (area[x][j] == 1 || area[x][j] == 2) break;
            if (!vis[x][j]) {
                vis[x][j] = true;
                countT++;
            }
        }

        // LEFT
        for (int y = j - 1; y >= 0; y--) {
            if (area[i][y] == 1 || area[i][y] == 2) break;
            if (!vis[i][y]) {
                vis[i][y] = true;
                countT++;
            }
        }

        // RIGHT
        for (int y = j + 1; y < n; y++) {
            if (area[i][y] == 1 || area[i][y] == 2) break;
            if (!vis[i][y]) {
                vis[i][y] = true;
                countT++;
            }
        }
    }

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        boolean[][] vis = new boolean[m][n];
        int[][] area = new int[m][n];

        // mark guards
        for (int[] g : guards) {
            area[g[0]][g[1]] = 1;
        }

        // mark walls
        for (int[] w : walls) {
            area[w[0]][w[1]] = 2;
        }

        // mark all guarded cells
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (area[i][j] == 1) {
                    count(area, i, j, vis);
                }
            }
        }

        // count unguarded cells
        return (m * n) - guards.length - walls.length - countT;
    }
}
