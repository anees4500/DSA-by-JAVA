class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        
         return helper(nums,k) - helper(nums,k-1);
    }

    public int helper(int[] nums , int goal){

        if(goal<0){
            return 0;
        }


        int count = 0;

        int ans = 0;

        int j = 0;

        for(int i = 0; i<nums.length; i++){
            
            if(nums[i]%2==1){
                count++;
            }

            while(j<nums.length && count>goal){
                if(nums[j]%2==1){
                    count--;
                }
                j++;
            }

            ans+= i - j+1;
        }

        return ans;
    }
}