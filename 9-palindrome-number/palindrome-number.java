class Solution {
    public boolean isPalindrome(int x) {
         
        int check = x;
        int ans = 0;
        while(x>0){
            ans = ans*10+ x%10;
            x = x/10;
           
        }
        if(ans == check){
            return true;
        }
        return false;
    }
}