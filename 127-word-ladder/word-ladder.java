class Solution {

    public boolean child(String a, String b) {

        int count = 0;

        for(int i = 0; i < a.length(); i++) {

            if(a.charAt(i) != b.charAt(i)) {
                count++;

                if(count > 1) {
                    return false;
                }
            }
        }

        return count == 1;
    }

    public int ladderLength(String beginWord,
                            String endWord,
                            List<String> wordList) {

        Set<String> set = new HashSet<>(wordList);

        if(!set.contains(endWord)) {
            return 0;
        }

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        Set<String> vis = new HashSet<>();
        vis.add(beginWord);

        int level = 1;

        while(!q.isEmpty()) {

            int size = q.size();

            for(int k = 0; k < size; k++) {

                String curr = q.poll();

                if(curr.equals(endWord)) {
                    return level;
                }

                for(String word : set) {

                    if(!vis.contains(word) && child(curr, word)) {

                        vis.add(word);
                        q.offer(word);
                    }
                }
            }

            level++;
        }

        return 0;
    }
}