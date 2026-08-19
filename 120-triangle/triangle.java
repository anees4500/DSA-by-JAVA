class Solution {

    public void helper(int dp[] , List<List<Integer>> triangle , int n){

        if(n<0){
            return;
        }
        List<Integer> li = triangle.get(n);
        for(int i = 0; i<li.size(); i++){
            dp[i] = li.get(i) + Math.min(dp[i] , dp[i+1]);
        }
        helper(dp, triangle,n-1);

    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        int dp[] = new int[n];

        for(int i = 0; i<n; i++){
            dp[i] = triangle.get(n-1).get(i);
        }

        helper(dp, triangle , n-2);
        return dp[0];
    }
}