class Solution {
    public int[] limitOccurrences(int[] nums, int k) {

        int count = 1;
        int prev = nums[0];
        int mm = 0;

        for(int i = 1 ; i<nums.length; i++){

            // if(count>k){
            //     prev = nums[i-1];
            //     nums[i-1] = -1;
            //     mm++;
                
            // }
            
            if(prev == nums[i]){
                count++;
            }
            else{
                count = 1;
                prev = nums[i];
            }

            if(count>k){
                prev = nums[i];
                nums[i] = -1;
                mm++;
                
            }


        }

        int j = 0;

        int ans[] = new int[nums.length-mm];

        for(int i = 0; i<nums.length; i++){
            if(nums[i]!=-1){
                ans[j++] = nums[i];
            }
        }

        return ans;


        
    }
}