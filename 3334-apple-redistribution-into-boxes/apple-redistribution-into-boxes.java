class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = 0;

        for(int i : apple){
            sum+=i;
        }

        Arrays.sort(capacity);
        int count = 0;

        int sum1 = 0;

        for(int i = capacity.length-1; i>=0; i--){
            sum1+=capacity[i];
            count++;

            if(sum1>=sum){
                return count;
            }
        }

        return 1;
    }
}