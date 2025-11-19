class Solution {
    public int findFinalValue(int[] nums, int original) {

        boolean found = true;

        while(found){
            found = false;
            for(int i = 0; i<nums.length; i++){
                if(nums[i]==original){
                    original = 2 * nums[i];
                    found = true;
                }
            }
        }
        return original;
    }
}