class Solution {
    public int findMin(int[] nums) {
        int min = 1;
        int lp = 0;
        int rp = nums.length-1;
        int mint =  Integer.MAX_VALUE;
        while(lp<=rp){
            int mid = lp + (rp-lp)/2;
            
            // left
            if(nums[lp]<=nums[mid]){
                mint = Math.min(mint,nums[lp]);
                lp = mid+1;
            }
            else{
                // right
                mint = Math.min(mint,nums[mid]);

                rp=mid-1;

            }

        }
        return mint;
    }
}