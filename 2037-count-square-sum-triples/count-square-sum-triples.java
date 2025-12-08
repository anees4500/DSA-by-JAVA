class Solution {
    public int countTriples(int n) {
        int count = 0;
       for(int i = 1; i<=n; i++){
           for(int j = 1; j<=n; j++){
                int sum = (int)(Math.pow(i,2) +  Math.pow(j,2));
                int sqrt = (int)Math.sqrt(sum);
                if((sqrt*sqrt)==sum && sqrt<=n){
                    count++;
                }
           }
        } 

        return count;
    }
}