class Solution {
    public List<Integer> findMissingElements(int[] nums) {

        List<Integer> list = new ArrayList<>();

        Arrays.sort(nums);

        int min = nums[0];

        int max = nums[nums.length-1];




        int l   = 0;
        for(int i = min; i<=max; i++){

            if(i==nums[l]){
                l++;
                continue;
            }
            else{
                list.add(i);
            }

        }

        return list;

        
    }
}