class Solution {

    public int ans(int[] dp, int i , int n , int[] nums){

        if(i>n){
            return 0;
        }

        if(dp[i]!=-1){
            return dp[i];
        }

         int leave = ans(dp,i+1,n, nums);
         int loot = nums[i] + ans(dp,i+2,n, nums);

         return dp[i] = Math.max(leave,loot);
    }


    public int rob(int[] nums) {
        
        int[] dp1 = new int[nums.length];

        int[] dp2 = new int[nums.length];

        if(nums.length==1){
            return nums[0];
        }

        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);

        int ans1 = ans(dp1, 0, nums.length-2, nums);
        int ans2 = ans(dp2,1, nums.length-1,nums);

        return Math.max(ans1,ans2);

    }
}