class Solution {
    public int reverseDegree(String s) {
        int sum = 0;
        for(int i = 0; i<s.length(); i++){

            int ch = s.charAt(i) - 'a' + 1;

            int rev = 27 - ch;

            sum +=  rev*(i+1);
        }

        return sum;
    }
}