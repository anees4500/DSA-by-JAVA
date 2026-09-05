class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        int min[] = new int[n];
        min[n-1] = nums[n-1];

        int temp = nums[n-1];

        for(int i = n-2; i>=0; i--){
            temp = Math.min(temp,nums[i]);
            min[i] = temp;
        }

        int max1 = Integer.MIN_VALUE;

        for(int i = 0; i<n; i++){
            max1 = Math.max(max1,nums[i]);
            int min1 = min[i];
            if(max1-min1<=k){
                return i;
            }
        }

        return -1;
    }
}