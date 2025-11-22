class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);

        int sum = 0;
        for(int i = 0; i<nums.length; i++){
            sum+=nums[i];
        }

        return sum - (nums.length *  nums[0]);
    }
}