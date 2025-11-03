class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int sell = 0;

        int ans = Integer.MIN_VALUE;

        for(int i = 1; i<prices.length; i++){
            if(prices[i]>buy){
                ans = Math.max(ans, prices[i]-buy);

            }
            else{
                buy = prices[i];
            }
        }

        if(ans==Integer.MIN_VALUE) return 0;
        else return ans;
    }
}