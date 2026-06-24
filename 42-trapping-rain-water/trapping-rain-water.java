class Solution {
    public int trap(int[] height) {
        int n = height.length; 
        if(n<=2){
            return 0;
        }

        int left = height[0];
        int right = height[height.length-1];

        int l = 1;
        int r =  n-2;

        int ans = 0;

   

        while(l<=r){
            // case 1

            

            // case 2

            // case 3

            if(left<=right){
                if(left<=height[l]){
                    left = height[l];
                    l++;
                }
                else{
                    int watLv = left - height[l];
                    ans += watLv ;
                    l++;
                }
                
            }
            else{
                if(right<=height[r]){
                    right = height[r];
                    r--;
                }
                else{
                    int watLv = right - height[r];
                    ans += watLv;
                    r--;
                }
            }
             

        }

        return ans;


    }
}