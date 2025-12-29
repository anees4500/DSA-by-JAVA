class Solution {
    public int maxScore(String s) {

        int ones = 0;
        for(char c : s.toCharArray()){
            if(c=='1') ones++;
        }

        int zeros = 0;
        int max = 0;

        for(int i=0; i<s.length()-1; i++){  // last index pe split allowed nahi
            if(s.charAt(i)=='0') zeros++;
            else ones--;

            max = Math.max(max, zeros + ones);
        }

        return max;
    }
}
