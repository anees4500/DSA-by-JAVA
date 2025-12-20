class Solution {
    public int minDeletionSize(String[] strs) {
        int j =0;
        int i = 0;
        int count = 0;
        while(j<strs[0].length()){
            i = 0;
            while(i<strs.length-1){
                if(strs[i].charAt(j)>strs[i+1].charAt(j)){
                    count++;
                    break;
                }
                i++;
            }
            j++;
        }
        return count;
        
         
    }
}