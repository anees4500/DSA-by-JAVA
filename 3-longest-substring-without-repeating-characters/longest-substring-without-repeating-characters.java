class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();

        int i = 0; 
        int j = 0;
        int max = 0;

        while(j<s.length()){
            char c = s.charAt(j);

            map.put(c,map.getOrDefault(c,0)+1);

            while(map.get(c)>1){
                map.put(s.charAt(i) , map.get(s.charAt(i++))-1);

            }
            

            max = Math.max(j-i+1, max);
            j++;
            
        }

        return max;
    }
}