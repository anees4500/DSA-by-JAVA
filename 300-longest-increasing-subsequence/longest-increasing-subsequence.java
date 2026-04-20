class Solution {
    

    public int helper(int nums[] , int[] num2 , int i , int j , int dp[][]){

        

        if(i>=nums.length || j>=num2.length){
            return 0;
        }

        if(dp[i][j]!=-1){
            return dp[i][j] ;
        }

         

        
        if(nums[i]==num2[j]){
            return dp[i][j] =  1 + helper(nums,num2, i + 1, j+1 , dp);
        }
        return dp[i][j] =  Math.max(helper(nums, num2 , i+1, j , dp) , helper(nums,num2, i , j+1 , dp));
    }


    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int num2[] = new int[n];

        



        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i<n; i++){
            set.add(nums[i]);
        }

        int dp[][] = new int[nums.length][num2.length];
        
        for(int i = 0; i<n; i++){
           Arrays.fill(dp[i] , -1);
        }

        // dp[0][0] = 1;

        int j = 0;

        for(int i : set){
            num2[j] = i;
            j++;
        }

        Arrays.sort(num2);

        return helper(nums, num2, 0 ,0 , dp);
        
    }

}