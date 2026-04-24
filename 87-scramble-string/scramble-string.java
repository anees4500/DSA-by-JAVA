import java.util.*;

class Solution {

    HashMap<String, Boolean> memo = new HashMap<>();

    public boolean helper(String s1, String s2) {

        // memo check
        String key = s1 + "#" + s2;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // same strings
        if (s1.equals(s2)) {

            memo.put(key, true);
            return true;
        }

        int n = s1.length();

        // pruning
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        if (!Arrays.equals(a, b)) {

            memo.put(key, false);
            return false;
        }

        // MCM partitions
        for (int i = 1; i < n; i++) {

            // no swap
            boolean noSwap =
                helper(s1.substring(0, i), s2.substring(0, i)) &&
                helper(s1.substring(i), s2.substring(i));

            if (noSwap) {

                memo.put(key, true);
                return true;
            }

            // swap
            boolean swap =
                helper(s1.substring(0, i), s2.substring(n - i)) &&
                helper(s1.substring(i), s2.substring(0, n - i));

            if (swap) {

                memo.put(key, true);
                return true;
            }
        }

        memo.put(key, false);

        return false;
    }

    public boolean isScramble(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        return helper(s1, s2);
    }
}