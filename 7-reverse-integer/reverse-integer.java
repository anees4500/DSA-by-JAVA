 class Solution {
    public int reverse(int x) {
        Stack<Character> st = new Stack<>();
        String str = String.valueOf(x);
        StringBuilder sb = new StringBuilder();

        int start = 0;
        if (str.charAt(0) == '-') start = 1;  // skip '-' sign

        
        for (int i = start; i < str.length(); i++) {
            st.push(str.charAt(i));
        }

        
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

       
        if (str.charAt(0) == '-') {
            sb.insert(0, '-');
        }

     
        long num = Long.parseLong(sb.toString());

         
        if (num > Integer.MAX_VALUE || num < Integer.MIN_VALUE) {
            return 0;
        }

        return (int) num;
    }
}
