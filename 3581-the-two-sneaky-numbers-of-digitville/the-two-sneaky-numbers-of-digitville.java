class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        int count = 0;
        for(int i : map.keySet()){
            if(map.get(i)>1){
                count++;
            }
        }

        int[] ans = new int[count];
        int j = 0;

        for(int i : map.keySet()){
            if(map.get(i)>1){
                ans[j++] =  i;
            }
        }

        return ans;
    }
}