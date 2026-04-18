class Solution {

    Long[][] mem;

    public long helper(int idx, int[] nums, int flag){

        if(idx >= nums.length){
            return 0;
        }

        if(mem[idx][flag] != null){
            return mem[idx][flag];
        }

        // skip → flag same
        long skip = helper(idx+1, nums, flag);

        long val = nums[idx];
        if(flag == 0){
            val = -val;
        }

        // take → flag flip
        long take = helper(idx+1, nums, 1-flag) + val;

        return mem[idx][flag] = Math.max(skip, take);
    }

    public long maxAlternatingSum(int[] nums) {

        mem = new Long[nums.length][2];

        return helper(0, nums, 1);
    }
}