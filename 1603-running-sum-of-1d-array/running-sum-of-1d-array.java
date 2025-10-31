class Solution {
    public int[] runningSum(int[] nums) {

        int sum = 0;
        int[] ans = new int[nums.length];

        for(int i = 0; i<nums.length; i++){
            ans[i] = nums[i] + sum;
            sum +=nums[i];
        }

        return ans;
    }
}