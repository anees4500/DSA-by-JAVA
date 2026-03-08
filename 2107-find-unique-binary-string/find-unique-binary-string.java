class Solution {
    public String findDifferentBinaryString(String[] nums) {

         int l = nums[0].length();

         int limit =(int) Math.pow(l,2);

         HashSet<String> set = new HashSet<>();

         for(String s : nums){
            set.add(s);
         }

         for(int i = 0; i<limit; i++){
            String binary = String.format("%"+l+"s", Integer.toBinaryString(i)).replace(' ', '0');
            if(!set.contains(binary)){
                return binary;
            }

         }

         return "1";

    }
}