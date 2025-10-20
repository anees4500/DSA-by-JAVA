 import java.util.*;

class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> set = new HashSet<>();
        int n = digits.length;

        // Try all combinations of 3 digits
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (i != j && j != k && i != k) {
                        int a = digits[i];
                        int b = digits[j];
                        int c = digits[k];
                        
                        // Must be a 3-digit number
                        if (a == 0) continue;
                        // Must be even
                        if (c % 2 != 0) continue;

                        int num = a * 100 + b * 10 + c;
                        set.add(num);
                    }
                }
            }
        }

        int[] ans = set.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(ans);
        return ans;
    }
}
