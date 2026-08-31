class Solution {
    public int minimumDeletions(int[] nums) {
        int mIdx = -1;
        int minIdx = -1;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = 0 ; i<nums.length; i++){
            if(max<nums[i]){
                max = nums[i];
                mIdx = i;
            }

            if(min>nums[i]){
                min = nums[i];
                minIdx = i;
            }
        }

        int both = 0;

        if(mIdx<minIdx){
            both = mIdx+1 +  nums.length - minIdx;
        }
        else{
            both = minIdx+1  + nums.length - mIdx ;
        }

        int left = 0;

        if(mIdx>minIdx){
            left = mIdx + 1;
        }
        else{
            left = minIdx+1;
        }

        int right = 0;

        if(mIdx<minIdx){
            right = nums.length - mIdx;
        }
        else{
            right = nums.length - minIdx;
        }

        return Math.min(left, Math.min(right, both));
    }
}