class Solution {
    public long countGood(int[] nums, int k) {
        long res = 0;
        int i = 0;
        int pairs = 0;
        

        HashMap<Integer,Integer> map = new HashMap<>();


        for(int j = 0; j<nums.length; j++) {
            int x = nums[j];
            int freq = map.getOrDefault(x,0);
            pairs += freq;
            map.put(nums[j],freq+1);

            while(pairs>=k){
                res+=nums.length - j;
                int freqL = map.get(nums[i]);

                map.put(nums[i],freqL-1);
                pairs-=(freqL-1);
                i++;
            }
        }
        return res;
    }
}