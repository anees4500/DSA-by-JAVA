class Solution {
    public int helper(int[] nums, int idx , int[]  dp){

        if(idx>=nums.length){
            return 0;
        }

        if(dp[idx]!=-1){
            return dp[idx];
        }
        int steal =nums[idx] +  helper(nums,idx+2,dp);
        int leave = helper(nums,idx+1, dp);
        

        return dp[idx] =  Math.max(steal,leave);

    }

    public int rob(int[] nums) {

        int dp[] = new int[nums.length];
        // Arrays.fill(dp,-1);

        if(nums.length<2){
            return nums[0];
        }

        dp[0] = nums[0];

        if(nums[1]>dp[0]){
            dp[1] = nums[1];
        }
        else{
            dp[1] = nums[0];
        }
       
       




        for(int i = 2; i<nums.length;i++){
            
            if((dp[i-2]+nums[i])>=dp[i-1]){

                dp[i] = nums[i] + dp[i-2];

            }
            else{
                dp[i]= dp[i-1];
            }
        }

        return dp[nums.length-1];

        // return helper(nums,0,dp);
    }
}