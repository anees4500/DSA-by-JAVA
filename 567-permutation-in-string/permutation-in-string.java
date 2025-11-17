 
class Solution {
    public  boolean checkInclusion(String s1, String s2) {

        
        if(s2.length() < s1.length()) return false;

        int[] target = new int[26];   // freq of p
        int[] window = new int[26];   // freq of current window of s

        for(char c : s1.toCharArray()){
            target[c - 'a']++;
        }

        int k = s1.length();

        for(int i = 0; i < s2.length(); i++){

            // add current char to window
            window[s2.charAt(i) - 'a']++;

            // remove char which goes out of window
            if(i >= k){
                window[s2.charAt(i - k) - 'a']--;
            }

            // if window size == k and freq matches → we found an anagram
            if(i >= k - 1){
                if(Arrays.equals(window, target)){
                    return true;
                }
            }
        }

        return false;
    }
}
