class Solution {

    int n;
    int minP;
    int[][] dp;

    private int rec(List<int[]> items, int[] cnt, int i, int left) {

        if (i == n) {
            return left / minP;
        }

        if (dp[i][left] != -1) {
            return dp[i][left];
        }

        int[] curr = items.get(i);
        int factor = curr[0];
        int price = curr[1];

        int notTake = rec(items, cnt, i + 1, left);

        int take = 0;

        if (left >= price) {
            take = rec(items, cnt, i + 1, left - price)
                    + cnt[i] + 1;
        }

        return dp[i][left] = Math.max(take, notTake);
    }

    public int maximumSaleItems(int[][] items, int budget) {

        List<int[]> nItems = new ArrayList<>();

        minP = 2000;

        for (int[] v : items) {
            nItems.add(new int[]{v[0], v[1]});
            minP = Math.min(minP, v[1]);
        }

        n = items.length;

        dp = new int[n][budget + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int[] freeCnt = new int[n];

        for (int i = 0; i < n; i++) {

            int factor = nItems.get(i)[0];

            for (int j = 0; j < n; j++) {

                if (i == j) continue;

                int ff = nItems.get(j)[0];

                if (ff % factor == 0) {
                    freeCnt[i]++;
                }
            }
        }

        return rec(nItems, freeCnt, 0, budget);
    }
}