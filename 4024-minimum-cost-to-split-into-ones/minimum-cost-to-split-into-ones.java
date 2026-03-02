class Solution {

    int cost = 0;

    public  void ans(int n){

        if(n<1){
            return;
        }

        

         
            int a = 1;
            int b = n-1;

            cost += a*b;

             
            if(b!=1){
                minCost(b);
            }

            
        
    }
    public int minCost(int n) {
        ans(n);
        return cost;    
    }
}