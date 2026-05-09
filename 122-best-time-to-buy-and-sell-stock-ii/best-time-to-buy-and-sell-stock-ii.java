class Solution {

    public int maxProfit(int[] prices) {

        int n = prices.length;

        int diff = 0;

        for(int i = 1; i < n; i++) {

            if(prices[i] > prices[i - 1]) {

                diff += prices[i] - prices[i - 1];
            }
        }

        return diff;
    }
}