import java.util.*;

class Solution {

    public int[] prevSmaller(int[] arr) {

        int n = arr.length;
        int[] pse = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            pse[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i);
        }

        return pse;
    }

    public int[] nextSmaller(int[] arr) {

        int n = arr.length;
        int[] nse = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            nse[i] = st.isEmpty() ? n : st.peek();

            st.push(i);
        }

        return nse;
    }

    public int sumSubarrayMins(int[] arr) {

        int MOD = 1000000007;

        int[] pse = prevSmaller(arr);
        int[] nse = nextSmaller(arr);

        long ans = 0;

        for (int i = 0; i < arr.length; i++) {

            long left = i - pse[i];
            long right = nse[i] - i;

            long contribution = ((left * right) % MOD * arr[i]) % MOD;

            ans = (ans + contribution) % MOD;
        }

        return (int) ans;
    }
}