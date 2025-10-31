class Solution {
    public int arrayPairSum(int[] nums) {

        Arrays.sort(nums);
        int sum = 0;

        for(int i = 1; i<nums.length; i = i+2){
            sum+=nums[i-1];
        }

        return sum;
    }
}