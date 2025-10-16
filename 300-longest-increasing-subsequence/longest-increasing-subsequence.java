 class Solution {
    public int lengthOfLIS(int[] nums) {
         int n = nums.length;
         HashSet<Integer> set = new HashSet<>();
         int[] nums2 = new int[n];

         for(int i : nums){
            set.add(i);
         }
         int j = 0;
         for(int i : set){
            nums2[j] = i;
            j++;
         }

         Arrays.sort(nums2);

         int dp[][] = new int[nums2.length+1][nums.length+1];

         for( int i = 0; i<nums2.length; i++){
            for(int l = 0; j<nums.length; j++){
                if(i==0){
                    dp[i][l] = l;
                }
                if(j==0){
                    dp[i][l] = i;
                }
            }
         }

         for( int i = 1; i<nums2.length+1; i++){
            for(int k = 1; k<n+1; k++){
                if(nums2[i-1]==nums[k-1]){
                    dp[i][k] = dp[i-1][k-1] +1;
                }
                else{
                    dp[i][k] = Math.max(dp[i-1][k], dp[i][k-1]);
                }
            }
         }

         return dp[nums2.length][n];
    }
}
