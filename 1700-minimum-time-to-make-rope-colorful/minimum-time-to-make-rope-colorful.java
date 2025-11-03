class Solution {
    public int minCost(String colors, int[] neededTime) {

        int count=0;
        int prev = 0;

       for(int  i = 1; i<neededTime.length; i++){
           if(colors.charAt(i)==colors.charAt(prev)){
                if(neededTime[prev]>neededTime[i]){
                    count+=neededTime[i];

                }
                else{
                    count+=neededTime[prev];
                    prev = i;
                }
           }
           else{
               prev = i;
           }
       } 

       return count;
    }
}