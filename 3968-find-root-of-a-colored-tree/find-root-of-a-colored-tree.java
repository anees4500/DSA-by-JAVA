import java.util.*;

class Solution {

    public class Pair {
        int node;
        char color;

        Pair(int node, char c) {
            this.node = node;
            this.color = c;
        }
    }

    boolean[] vis;

    public int dfs(int ans, String colors,
                   List<List<Integer>> adj) {

        Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(ans, colors.charAt(ans)));

        vis = new boolean[colors.length()];
        vis[ans] = true;

        while (!qu.isEmpty()) {

            Pair curr = qu.poll();
            int node = curr.node;
            char co = curr.color;

             
            int count = 0;

            for (int j : adj.get(node)) {

                

                

                if (vis[j]) {
                    continue;
                }

                count++;

                if(count>2){
                    return -1;
                }

                char nextColor = colors.charAt(j);

                if ((co == 'R' && nextColor == 'B') ||
                    (co == 'B' && nextColor == 'W') ||
                    (co == 'W' && nextColor == 'R')) {

                    vis[j] = true;
                    qu.add(new Pair(j, nextColor));

                } else {
                    return -1;
                }
            }
        }

        return ans;
    }

    public int findColoredRoot(int[][] edges, String colors) {

        int n = colors.length();
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build adjacency list
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        for (int i = 0; i < n; i++) {
            if (dfs(i, colors, adj) != -1) {
                return i;
            }
        }

        return -1;
    }
}