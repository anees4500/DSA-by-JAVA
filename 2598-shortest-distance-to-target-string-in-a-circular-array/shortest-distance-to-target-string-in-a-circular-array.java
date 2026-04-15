class Solution {

    public int ford(String[] words, String tar, int idx, int start){
        
        if(words[idx].equals(tar)){
            return 0;
        }

        int next = (idx + 1) % words.length;

        // full circle ho gaya → target nahi mila
        if(next == start){
            return (int)1000000002;
        }

        return 1 + ford(words, tar, next, start);
    }

    public int back(String[] words, String tar, int idx, int start){

        if(words[idx].equals(tar)){
            return 0;
        }

        int prev = (idx - 1 + words.length) % words.length;

        // full circle complete
        if(prev == start){
            return (int)1000000002;
        }

        return 1 + back(words, tar, prev, start);
    }

    public int closestTarget(String[] words, String target, int startIndex) {

        int f = ford(words, target, startIndex, startIndex);
        int b = back(words, target, startIndex, startIndex);

        int ans = Math.min(f, b);

        return ans >= (int)1000000002 ? -1 : ans;
    }
}