class Solution {
    public int[] dailyTemperatures(int[] tem) {
        int ans[] = new int[tem.length];

        Stack<Integer> st = new Stack<>();

        int n = tem.length-1;


        for(int i  = n; i>=0 ; i--){
            if(i==n){
                ans[i] = 0;
                st.push(i);
                continue;
            }
            
            while(!st.isEmpty() &&  tem[i]>=tem[st.peek()]){
                st.pop();



            }

            if(st.size()==0){
                ans[i] = 0;
                st.push(i);
            }
            else{
                ans[i] =  st.peek() - i;
                st.push(i);
            }
        }

        return ans;

    }
}