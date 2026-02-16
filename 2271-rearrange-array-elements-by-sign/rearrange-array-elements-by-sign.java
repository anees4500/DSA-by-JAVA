class Solution {
    public int[] rearrangeArray(int[] nums) {


        int i = 0;
        int j = 1;
        int cr = 0;

        int ans[] =  new int[nums.length];


        while(cr<nums.length){
            if(nums[cr]>0){
                ans[i] = nums[cr];
                i= i+2;
            }
            else{
                ans[j] = nums[cr];
                j= j+2;
            }
            cr++;
        }

        return ans;
        
    }
}