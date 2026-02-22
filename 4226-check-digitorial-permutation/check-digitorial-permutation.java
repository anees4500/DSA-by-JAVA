import java.util.*;

class Solution {

   
    int[] fact = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

    public boolean isDigitorialPermutation(int n) {

        int sum = 0;
        int temp = n;

     
        while (temp > 0) {
            int digit = temp % 10;
            sum += fact[digit];
            temp /= 10;
        }

        
        return sameDigits(n, sum);
    }

    private boolean sameDigits(int a, int b) {
        int[] freq = new int[10];

        while (a > 0) {
            freq[a % 10]++;
            a /= 10;
        }

        while (b > 0) {
            freq[b % 10]--;
            b /= 10;
        }

        for (int f : freq) {
            if (f != 0) return false;
        }

        return true;
    }
}