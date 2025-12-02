class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);

        int max  = nums[nums.length-1];

        int hav = (nums.length)*max;

        int tot = 0;
        for(int i : nums){
            tot+=i;
        }

        return hav - tot;
    }
}