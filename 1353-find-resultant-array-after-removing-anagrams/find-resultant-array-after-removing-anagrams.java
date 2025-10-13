 import java.util.*;

class Solution {
    public boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> map1 = new HashMap<>();

        for (char c : a.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        for (char c : b.toCharArray())
            map1.put(c, map1.getOrDefault(c, 0) + 1);

        for (char key : map.keySet()) {
            if (!map1.containsKey(key) || !map.get(key).equals(map1.get(key)))
                return false;
        }

        return true;
    }

    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        ans.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            if (!isAnagram(words[i - 1], words[i])) {
                ans.add(words[i]);
            }
        }

        return ans;
    }
}
