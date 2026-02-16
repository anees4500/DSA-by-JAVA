class Solution {
    public boolean search(int[] nums, int target) {
        
        int lp = 0;
        int rp = nums.length-1;

        while(lp<=rp){
            int mid = lp + (rp-lp)/2;

            if(nums[mid]==target){
                return true;
            }

            if (nums[lp] == nums[mid] && nums[mid] == nums[rp]) {
                lp++;
                rp--;
            }
            else if(nums[lp]<=nums[mid]){
                if(target>=nums[lp] && target<nums[mid]){
                    rp = mid-1;
                }
                else{
                    lp = mid +1;
                }
            }
            else{
                if(target>nums[mid] && target<=nums[rp]){
                    lp = mid + 1;
                }
                else{
                    rp = mid-1;
                }
            }
        }
        return false;
    }
}