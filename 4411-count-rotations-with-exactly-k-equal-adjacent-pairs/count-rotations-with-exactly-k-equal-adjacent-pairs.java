class Solution {
    public int countRotations(String s, int k) {

        int ans = 0;
        int j = 0;
        String str = s+ "";
        while(j<s.length()){

             str = str.substring(1) + str.substring(0,1);

            int count = 0;

            for(int i = 1; i<str.length(); i++){
                if(str.charAt(i-1)==str.charAt(i)){
                    count++;
                }
            }

            if(count==k){
                ans++;
            }
            j++;

        }

        return ans;
    }
}