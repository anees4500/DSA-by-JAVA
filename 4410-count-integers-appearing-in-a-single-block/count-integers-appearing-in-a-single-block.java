class Solution {
    public int countSpecialIntegers(int[] nums) {
        

        int count = 0;

        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i<nums.length; i++){

            int j = i;

            map.put(nums[i] , map.getOrDefault(nums[i], 0)+1);

            while(j<nums.length-1 && nums[i]==nums[j+1]){
                j++;
            }

            

            i = j;
            
            
        }

        for(int i : map.keySet()){
            if(map.get(i)==1){
                count++;
            }
        }

        return count;
    }
}