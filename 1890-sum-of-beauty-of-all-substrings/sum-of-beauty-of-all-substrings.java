class Solution {

    public int Check(String s, int i, int j) {

        int freq[] = new int[26];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        while (i <= j) {
            freq[s.charAt(i) - 'a']++;
            i++;
        }

        for (int k = 0; k < 26; k++) {

            if (freq[k] == 0)
                continue;

            min = Math.min(min, freq[k]);
            max = Math.max(max, freq[k]);
        }

        return max - min;
    }

    public int beautySum(String s) {

        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            for (int j = i + 1; j < s.length(); j++) {

                count += Check(s, i, j);
            }
        }

        return count;
    }
}