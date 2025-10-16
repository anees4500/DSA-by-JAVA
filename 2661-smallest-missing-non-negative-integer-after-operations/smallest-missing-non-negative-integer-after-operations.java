class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int n = nums.length;

        HashMap<Integer,Integer> map = new HashMap<>();

        for( int i : nums){
            int mod = ((i%value)+value)%value;

            map.put(mod,map.getOrDefault(mod,0)+1);
        }

        for(int j = 0; ; j++){
            int mod = j%value;
            if(map.getOrDefault(mod,0)==0){
                return j;
            }
            else{
                map.put(mod,map.get(mod)-1);
            }
        }
    }
}