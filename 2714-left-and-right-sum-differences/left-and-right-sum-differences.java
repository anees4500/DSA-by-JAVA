class Solution {
    public int[] leftRightDifference(int[] nums) {
        

        int leftSum = 0;

        int right = 0;

        for(int i = 0; i<nums.length; i++){
            right+=nums[i];
        }

        int ans[] = new int[nums.length];


        for(int i = 0; i<nums.length; i++){
            right = right - nums[i];
            ans[i] = Math.abs(right - leftSum);
            leftSum += nums[i];
        }

        return ans;
    }
}