class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumEven =  n*(n+1);

        int sumOdd = n*n;

        int ans  = 1;

        int div = 2;

        while(div<=sumEven && div<=sumOdd){

            if(sumEven%div==0 && sumOdd%div==0){
                ans = div;
            }
            div++;
        }

        return ans;
    }
}