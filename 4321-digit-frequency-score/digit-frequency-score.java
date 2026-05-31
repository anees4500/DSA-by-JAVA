class Solution {
    public int digitFrequencyScore(int n) {
        
        int sum = 0;

        String str = String.valueOf(n);


        for(int i= 0; i<str.length(); i++){
            sum+=str.charAt(i)- '1'+1;
        }

        return sum;
    }
}