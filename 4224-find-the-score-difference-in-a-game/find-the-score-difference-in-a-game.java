class Solution {
    public int scoreDifference(int[] nums) {
        int score1 = 0;
        int score2 = 0;

        int role = 1;

        for (int i = 0; i < nums.length; i++) {

            
            if (nums[i] % 2 == 1) {
                role = (role == 1) ? 2 : 1;
            }

            
            if (i % 6 == 5) {
                role = (role == 1) ? 2 : 1;
            }

            // active player gains points
            if (role == 1) {
                score1 += nums[i];
            } else {
                score2 += nums[i];
            }
        }

        return score1 - score2;
    }
}