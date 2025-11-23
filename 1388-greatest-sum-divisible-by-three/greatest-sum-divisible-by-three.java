class Solution {
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        int sum = 0;
        List<Integer> remain1 = new ArrayList<>();
        List<Integer> remain2 = new ArrayList<>();
        for(int i=0; i<n; i++){
            sum += nums[i];
            if(nums[i] % 3 == 1){
                remain1.add(nums[i]);
            }
            else if(nums[i] % 3 == 2){
                remain2.add(nums[i]);
            }
        }
        if(sum % 3 == 0) return sum;
        int result = 0;
        Collections.sort(remain1);
        Collections.sort(remain2);
        int remainder = sum%3;
        if(remainder == 1){
            int remove1 = remain1.size() >= 1 ? remain1.get(0) : Integer.MAX_VALUE;
            int remove2 = remain2.size() >= 2 ? remain2.get(0) + remain2.get(1) : Integer.MAX_VALUE;
            result = sum - Math.min(remove1,remove2);
        }
        else{
            int remove2 = remain2.size() >= 1 ? remain2.get(0) : Integer.MAX_VALUE;
            int remove1 = remain1.size() >= 2 ? remain1.get(0) + remain1.get(1) : Integer.MAX_VALUE;
            result = sum - Math.min(remove1,remove2);
        }
        return Math.max(result,0);
    }
}