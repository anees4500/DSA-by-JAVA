class Solution {

    public String reverse(String str){

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<str.length(); i++){
            if(str.charAt(i)=='1'){
                sb.append('0');
            }
            else{
                sb.append('1');
            }
        }
        return sb.reverse().toString();
    }


    public char findKthBit(int n, int k) {
        String ans = "0";

        for(int i = 2; i<=n; i++){
            ans = ans + "1" + reverse(ans);
        }

        return ans.charAt(k-1);
    }
}