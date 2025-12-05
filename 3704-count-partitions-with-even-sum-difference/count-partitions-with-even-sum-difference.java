class Solution {
    public int countPartitions(int[] nums) {

        int sum = 0;
        int pre[] = new int[nums.length];
        int j = 0;

        for(int i : nums){
            sum+=i;
            pre[j] = sum;
            j++;

        }

        int count = 0;

        for(int i = 1; i<nums.length; i++){
            if(Math.abs(pre[i-1]-(sum - pre[i-1]))%2==0){
                count++;
            }
        }

        return count;

    }
}