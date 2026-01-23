class Solution {
    public boolean isAnagram(String s, String t) {

        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();

        if(s.length()!=t.length()){
            return false;
        }

        
        for(int i = 0; i<s.length(); i++){

            map1.put(s.charAt(i),map1.getOrDefault(s.charAt(i),0)+1);
            map2.put(t.charAt(i),map2.getOrDefault(t.charAt(i),0)+1);
        }
         
        for (char ch : map1.keySet()) {
            if (!map1.get(ch).equals(map2.get(ch))) {
                return false;
            }
        }

        return true;
    }
}