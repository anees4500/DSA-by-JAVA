class Solution {

    long dp[][] ;

    public long helper(int[] nums , int i  , int flag){

        if(i>=nums.length){
            return 0;
        }

        if(dp[i][flag]!=-1){
            return dp[i][flag];
        }



        long skip = helper(nums, i + 1, flag);

        int val = nums[i];

        if(flag==0){
            val = -val;
        }

      

        long take = helper(nums, i+ 1, 1-flag) + val;

        return dp[i][flag] = Math.max(take,skip );
    }
    public long maxAlternatingSum(int[] nums) {

        dp = new long[nums.length][2];

        for(int i = 0; i<nums.length; i++){
            Arrays.fill(dp[i], -1);
        }

        

        return helper(nums , 0, 1);



    }
}