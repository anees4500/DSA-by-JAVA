class Solution {
    public int minMoves(int[] nums) {
        // Arrays.sort(nums);

        int max  =  Integer.MIN_VALUE;

        

        int tot = 0;
        for(int i : nums){

            max = Math.max(max, i);

            tot+=i;
        }

        int hav = (nums.length)*max;

        return hav - tot;
    }
}