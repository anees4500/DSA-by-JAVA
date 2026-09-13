class Solution {
    public int longestOnes(int[] nums, int k) {
        

        int i = 0;
        int j = 0;

        int count = k;

        int ans = 0;

        while(j<nums.length){

            if(nums[j]==0){
                count--;
            }

            while(i<nums.length && count<0){
                if(nums[i]==0){
                    count++;
                }
                i++;
            }

            ans = Math.max(ans, j-i+1);
            j++;
        }

        return ans;
    }
}