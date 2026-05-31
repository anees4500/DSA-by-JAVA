class Solution {
    public int[] productExceptSelf(int[] nums) {

       int n = nums.length; 


       int left[] = new int[n];
       left[0] = nums[0];

       for(int i = 1 ; i<n; i++){
            left[i] = left[i-1] * nums[i];
       } 

       int right = 1;

        for(int i = n-1; i>=0; i--){
           if(i==n-1){
               left[i] = left[i-1];
               right = nums[i] * 1;
           }
           else if(i==0){
                left[i] = right;

           }
           else{
              left[i] = left[i-1] * right;

              right = right * nums[i];
           }            
        }

        return left;
    }
}