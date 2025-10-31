class Solution {
    public int sum(int[] arr, int i , int j ){
        int s = 0;
        while(i<j){
           s+=arr[i];
           i++;
        }
        return s;
    }
    public int pivotIndex(int[] nums) {
        if(nums.length==1) return 0;

        for(int i = 0; i<nums.length; i++){
            int sum1 = sum(nums, 0 , i);
            int sum2 = sum(nums, i+1, nums.length);
            if(sum1==sum2){
                return i;
            }
        }
        return -1;
    }
}