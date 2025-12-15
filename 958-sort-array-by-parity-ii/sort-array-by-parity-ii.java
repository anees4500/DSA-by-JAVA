class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int i = 0; int j = 1;
        int k = 0;

        int ans[] = new int[nums.length];

        while(k<nums.length){
            if(nums[k]%2==0){
               ans[i] = nums[k]; 
               i = i+2;
            }
            else{
               ans[j] = nums[k]; 
               j = j+2; 
            }
            k++;
        }

        return ans;


    }
}