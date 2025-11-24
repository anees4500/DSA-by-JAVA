class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> list = new ArrayList<>();

        int curr = 0;

        for(int bit : nums){

            curr = (curr * 2 + bit) % 5;

            list.add(curr == 0);
        }

        return list;
    }

}
