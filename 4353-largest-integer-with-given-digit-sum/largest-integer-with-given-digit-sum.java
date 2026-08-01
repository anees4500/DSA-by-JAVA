class Solution {
    public int largestInteger(int n, int s) {
        if(n*9<s){
            return -1;
        }

        int ans = 0;

        int count = 0;



        while(count<n){
            for(int i = 9 ; i>=0; i--){
                
                
                if(s-i>=0){
                     ans = ans*10 + i ;
                     s = s - i;
                     count++;
                     break;
                }
            }

        }

        return ans;

    }
}