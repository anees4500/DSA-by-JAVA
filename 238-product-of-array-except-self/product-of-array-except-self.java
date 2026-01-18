class Solution {

    public int[] productExceptSelf(int[] nums) {
        
        int pro = 1;

        for(int i = 0; i<nums.length; i++){

            pro = pro*nums[i];
        }

        int[] ans = new int[nums.length];
        
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0] = 1;
        right[nums.length-1] = 1;

        int j = nums.length-2;

        for(int i = 1; i<nums.length; i++){
            left[i] = left[i-1]*nums[i-1];
            right[j] = right[j+1]* nums[j+1];
            j--;
        }

        for(int i = 0; i<nums.length; i++){
            ans[i]= right[i]*left[i];
        }

        return ans;
    }
}