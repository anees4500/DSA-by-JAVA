class Solution {
    public int minimumPushes(String word) {

        Map<Character, Integer> map = new HashMap<>();

        for (char c : word.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> list =
                new ArrayList<>(map.entrySet());

        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        int count = 0;
        int fac = 1;
        int ele = 0;

        for (Map.Entry<Character, Integer> entry : list) {

            if (ele >= 8) {
                ele = 0;
                fac++;
            }

            count += entry.getValue() * fac;
            ele++;
        }

        return count;
    }
}