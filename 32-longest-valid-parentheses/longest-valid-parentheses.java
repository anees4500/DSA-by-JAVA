class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();

        st.add(-1);

        int max = 0;

        int n = s.length();

        for(int i = 0; i< n; i++){

            // if (

            if(s.charAt(i)=='('){
                st.add(i);
            }
            else{  // if )
                st.pop();
                if(st.isEmpty()){
                    st.push(i);
                }

                max = Math.max(i - st.peek() , max);
            }

                
             
        }

        return max;
    }
}