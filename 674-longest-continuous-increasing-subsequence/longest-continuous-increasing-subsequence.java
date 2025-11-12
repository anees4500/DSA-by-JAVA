class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int count = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i]<nums[i+1]){
                count++;
                max = Math.max(max,count);
            }
            else{
                count=0;
            }
        }
        if(max==Integer.MIN_VALUE) return 1;
        return max +1;
    }
}