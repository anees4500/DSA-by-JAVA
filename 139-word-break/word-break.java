 class Solution {

    public class Node {
        Node[] children = new Node[26];
        boolean eow = false;
    }

    Node root = new Node();
    Map<String, Boolean> memo = new HashMap<>();

    public void insert(String str){
        Node curr = root;

        for(int i = 0; i < str.length(); i++){
            int idx = str.charAt(i) - 'a';

            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }

            curr = curr.children[idx];

            if(i == str.length() - 1){
                curr.eow = true;
            }
        }
    }

    public boolean search(String key){
        Node curr = root;

        for(int i = 0; i < key.length(); i++){
            int idx = key.charAt(i) - 'a';

            if(curr.children[idx] == null){
                return false;
            }

            curr = curr.children[idx];

            if(i == key.length() - 1 && curr.eow == false){
                return false;
            }
        }

        return true;
    }

    public boolean wb(String s, List<String> wd){

        if(s.length() == 0){
            return true;
        }

        // ⭐ MEMOIZATION (MAIN FIX)
        if(memo.containsKey(s)) return memo.get(s);

        for(int i = 1; i <= s.length(); i++){

            String pre = s.substring(0, i);
            String suf = s.substring(i);

            if(search(pre) && wb(suf, wd)){
                memo.put(s, true);
                return true;
            }
        }

        memo.put(s, false);
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {

        for(String w : wordDict){
            insert(w);
        }

        return wb(s, wordDict);
    }
}
