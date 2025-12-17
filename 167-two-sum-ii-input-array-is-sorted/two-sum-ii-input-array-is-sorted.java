class Solution {
    public int[] twoSum(int[] arr, int target) {
        int[] ans = new int[2];
        int n = arr.length;
        int left = 0;
        int right = n-1;

        while(left < right){
            int sum = arr[left] + arr[right];
            if((sum) == target){
                ans[0] = left+1;
                ans[1] = right+1;
                return ans;
            }
            if(sum < target) left++;
            else right--;
        }
         

        return ans;
    }
}