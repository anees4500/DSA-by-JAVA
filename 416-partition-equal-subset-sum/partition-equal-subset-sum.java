class Solution {

    public boolean func(int i, int target, int[] nums, Boolean[][] dp) {

        if(target == 0){
            return true;
        }

        if(i == 0){
            return nums[0] == target;
        }

        if(dp[i][target] != null){
            return dp[i][target];
        }

        boolean notTake = func(i - 1, target, nums, dp);

        boolean take = false;

        if(nums[i] <= target){
            take = func(i - 1, target - nums[i], nums, dp);
        }

        return dp[i][target] = take || notTake;
    }

    public boolean canPartition(int[] nums) {

        int sum = 0;

        for(int num : nums){
            sum += num;
        }

        if(sum % 2 != 0){
            return false;
        }

        int target = sum / 2;

        Boolean[][] dp = new Boolean[nums.length][target + 1];

        return func(nums.length - 1, target, nums, dp);
    }
}