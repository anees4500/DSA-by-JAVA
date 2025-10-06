class Solution {
    public static boolean helper(int[] arr, int sum, int i, Boolean[][] dp) {
        if(sum == 0) return true;
        if(i == arr.length) return false;

        if(dp[i][sum] != null) return dp[i][sum];

        if(arr[i] > sum) 
            dp[i][sum] = helper(arr, sum, i+1, dp);
        else
            dp[i][sum] = helper(arr, sum - arr[i], i+1, dp) || helper(arr, sum, i+1, dp);

        return dp[i][sum];
    }


    public boolean canPartition(int[] nums) {
        int sum = 0;

        for(int i = 0; i<nums.length; i++){
            sum+=nums[i];
        }

        if(sum%2==1){
            return false;
        }

        Boolean[][] dp = new Boolean[nums.length][sum/2 +1];

        return helper(nums,sum/2 , 0 , dp);




    }
}