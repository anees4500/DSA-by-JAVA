class Solution {
    public int maxAdjacentDistance(int[] nums) {
         

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i<nums.length; i++){
            if(i==0){
                pq.offer(Math.abs(nums[nums.length-1]-nums[0]));
                pq.offer(Math.abs(nums[0]-nums[1]));

            }
            else if(i==nums.length-1){
                pq.offer(Math.abs(nums[i-1]-nums[i]));
                pq.offer(Math.abs(nums[i]-nums[0]));
            }
            else{
                pq.offer(Math.abs(nums[i-1]-nums[i]));
                pq.offer(Math.abs(nums[i]-nums[i+1]));
            }
        }

        return pq.poll();



        

    }
}