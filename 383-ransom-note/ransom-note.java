class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        HashMap<Character,Integer> l1 = new HashMap<>();
        HashMap<Character,Integer> l2 = new HashMap<>();

        for( char i : ransomNote.toCharArray()){
            l1.put(i,l1.getOrDefault(i,0)+1);
        }

        for(char j : magazine.toCharArray()){
            l2.put(j , l2.getOrDefault(j,0)+1);
        }

        for(char k : l1.keySet()){
             
            if( !l2.containsKey(k) ||  l1.get(k)>l2.get(k)){
                return false;
            }
        }

        // for (char k : l1.keySet()) {
        //     if (!l2.containsKey(k) || l1.get(k) > l2.get(k)) {
        //         return false;
        //     }
        // }

        return true;



    }
}