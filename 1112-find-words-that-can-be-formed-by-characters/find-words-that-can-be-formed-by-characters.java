 import java.util.*;

class Solution {
    public int countCharacters(String[] words, String chars) {
         
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : chars.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int count = 0;

        for (String word : words) {
            HashMap<Character, Integer> temp = new HashMap<>(map);
            boolean canForm = true;

            for (char c : word.toCharArray()) {
                if (!temp.containsKey(c) || temp.get(c) == 0) {
                    canForm = false;
                    break;
                }
                temp.put(c, temp.get(c) - 1);  
            }

            if (canForm) {
                count += word.length();
            }
        }

        return count;
    }
}
