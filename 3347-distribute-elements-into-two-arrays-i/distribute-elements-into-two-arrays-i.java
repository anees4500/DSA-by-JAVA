class Solution {
    public void helper(int[] nums ,int  up){
        for(int i = up+1; i<nums.length-1; i++){

            nums[i] = nums[i+1];

        }
    }
    public int[] resultArray(int[] nums) {
        int ans[] = new int[nums.length];

        

        int i = 0;
        int j = nums.length-1;

        ans[0] = nums[0];
        ans[j] = nums[1];



        for(int k = 2; k<nums.length; k++){
            // case 1  if arr1>arr2
            if(ans[i]>ans[j]){
                i++;
                ans[i] = nums[k];
            }
            else{
                
                helper(ans, i);
                ans[j] = nums[k];

            }
            // case 2 if(arr1<arr2)
        }

        return ans;
    }
}