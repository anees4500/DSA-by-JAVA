class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] str = s.trim().split("\\s+");


        if(str.length != pattern.length()){
            return false;
        }

        HashMap<Character,String> map = new HashMap<>();

        HashSet<Character> set = new HashSet<>();

        for(int i = 0; i<pattern.length(); i++){
            if(set.contains(pattern.charAt(i))){
                 if (!map.get(pattern.charAt(i)).equals(str[i])) {
                    return false;
                }
                
                
            }
            else{

                map.put(pattern.charAt(i),str[i]);
                
                set.add(pattern.charAt(i));
            }
        }
        HashSet<String> set2 = new HashSet<>();
        for (String st2 : map.values()) {
            if (set2.contains(st2)) {
                return false;
            } else {
                set2.add(st2);
            }
        }

        return true;
    }
}