class Solution {
    public void sortColors(int[] nums) {
        int c0 = 0;
        int c1 = 0;
        int c2 = 0;

        for(int i= 0; i<nums.length; i++){
            if(nums[i]==0){
                c0++;
            }
            else if(nums[i]==1){
                c1++;
            }
            else if(nums[i]==2){
                c2++;
            }
            
        }

        int i = 0;
        int j = 0;
        while(j<c0){
            nums[i]=0;
            i++;
            j++;
        }
        j=0;

        while(j<c1){
            nums[i]=1;
            i++;
            j++;
        }

        j=0;

        while(j<c2){
            nums[i]=2;
            i++;
            j++;
        }

        
    }
}