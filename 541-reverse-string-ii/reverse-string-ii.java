 class Solution {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();

        for (int start = 0; start < s.length(); start += 2 * k) {
            int i = start;
            int j = Math.min(start + k - 1, s.length() - 1); // reverse only first k characters
            
            // reverse characters between i and j
            while (i < j) {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        return new String(arr);
    }
}
