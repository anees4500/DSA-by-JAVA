 class Solution {

    // DFS to count chain detonations
    public int dfs(int curr, List<List<Integer>> list, boolean[] visited) {
        visited[curr] = true;
        int count = 1; // current bomb

        int dx = list.get(curr).get(0);
        int dy = list.get(curr).get(1);
        int r = list.get(curr).get(2);

        for(int i = 0; i < list.size(); i++) {
            if(visited[i]) continue;
            int x = list.get(i).get(0);
            int y = list.get(i).get(1);

            double distance = Math.sqrt(Math.pow(x-dx,2) + Math.pow(y-dy,2));
            if(distance <= r) {
                count += dfs(i, list, visited);
            }
        }

        return count;
    }

    public int maximumDetonation(int[][] bombs) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < bombs.length; i++) {
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j < 3; j++) {
                temp.add(bombs[i][j]);
            }
            list.add(temp);
        }

        int maxSum = 0;
        for(int i = 0; i < bombs.length; i++) {
            boolean[] visited = new boolean[bombs.length];
            int max = dfs(i, list, visited);
            maxSum = Math.max(max, maxSum);
        }

        return maxSum;
    }
}
