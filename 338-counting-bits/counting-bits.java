class Solution {
    public int count(int n){
        int mask = 1;
        int count = 0;
        while(n>0){
            if((n&1)!=0){
                count++;
            }
            n = n>>1;
        }

        return count;
    }
    public int[] countBits(int n) {
        int[] ans = new int[n+1];

        for(int i = 0; i<=n; i++ ){

            int out = count(i);

            ans[i] = out;


        }
        return ans;
    }
}