class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<>();
        if(s.length() < p.length()) return ans;

        int[] target = new int[26];   // freq of p
        int[] window = new int[26];   // freq of current window of s

        for(char c : p.toCharArray()){
            target[c - 'a']++;
        }

        int k = p.length();

        for(int i = 0; i < s.length(); i++){

            // add current char to window
            window[s.charAt(i) - 'a']++;

            // remove char which goes out of window
            if(i >= k){
                window[s.charAt(i - k) - 'a']--;
            }

            // if window size == k and freq matches → we found an anagram
            if(i >= k - 1){
                if(Arrays.equals(window, target)){
                    ans.add(i - k + 1);
                }
            }
        }

        return ans;
    }
}
