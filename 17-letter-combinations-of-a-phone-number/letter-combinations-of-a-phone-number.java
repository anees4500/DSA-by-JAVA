class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();

        HashMap<Character,char[]> map = new HashMap<>();
        map.put('2', new char[]{'a','b','c'});
        map.put('3', new char[]{'d','e','f'});
        map.put('4', new char[]{'g','h','i'});
        map.put('5', new char[]{'j','k','l'});
        map.put('6', new char[]{'m','n','o'});
        map.put('7', new char[]{'p','q','r','s'});
        map.put('8', new char[]{'t','u','v'});
        map.put('9', new char[]{'w','x','y','z'});

        List<String> result = new ArrayList<>();
        result.add("");

        for (char d : digits.toCharArray()) {
            char[] letters = map.get(d);
            List<String> next = new ArrayList<>();

            for (String prefix : result) {
                for (char ch : letters) {
                    next.add(prefix + ch);
                }
            }

            result = next;
        }

        return result;
    }
}
