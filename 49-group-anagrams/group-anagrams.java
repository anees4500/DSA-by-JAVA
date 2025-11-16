class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String , List<String>> map = new HashMap<>();

        for(int i = 0; i<strs.length; i++){
            String str = strs[i];

            char ch[] = str.toCharArray();

            Arrays.sort(ch);

            String st = new String(ch);

            if(!map.containsKey(st)){
                map.put(st,new ArrayList<>());
            }
            map.get(st).add(str);


        }

        List<List<String>> ans = new ArrayList<>();

        for(String s : map.keySet()){
            ans.add(new ArrayList<>(map.get(s)));
        }

        return ans;
    }
}