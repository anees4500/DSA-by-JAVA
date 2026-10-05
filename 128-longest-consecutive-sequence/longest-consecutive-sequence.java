class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> set = new HashSet<>();

        int maxLen = 0;

        for(int i = 0; i<nums.length; i++){
            set.add(nums[i]);
        } 

        for(int i : set){

            if(!set.contains(i-1)){
                int curr = i ;
                int count = 1;

                while(set.contains(curr+1)){
                    count++;
                    curr++;
                }

                maxLen = Math.max(maxLen,count);
            }
        }

        return maxLen ;
    }
}