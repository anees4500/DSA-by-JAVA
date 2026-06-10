class Solution {

    public Character ch(Map<Character, Integer> map,
                        boolean vis[],
                        int val) {

        for(char c : map.keySet()) {
            if(!vis[c - 'a'] && map.get(c) == val) {
                return c;
            }
        }
        return '-';
    }

    public boolean closeStrings(String word1, String word2) {

        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> ref = new HashMap<>();

        for(char c : word1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(char c : word2.toCharArray()) {
            ref.put(c, ref.getOrDefault(c, 0) + 1);
        }

        if(map.size() != ref.size()) {
            return false;
        }

        for(char c : map.keySet()) {
            if(!ref.containsKey(c)) {
                return false;
            }
        }

        boolean vis[] = new boolean[26];

        for(char c : word1.toCharArray()) {

            if(vis[c - 'a']) {
                continue;
            }

            if(!ref.containsKey(c)){
                return false;
            }

            if(map.get(c).equals(ref.get(c))) {
                vis[c - 'a'] = true;
                continue;
            }

            int t = ref.get(c);

            Character mask = ch(map, vis, t);

            if(mask == '-') {
                return false;
            }

            int temp = map.get(c);

            map.put(c, map.get(mask));
            map.put(mask, temp);

            vis[c - 'a'] = true;
        }

        return true;
    }
}