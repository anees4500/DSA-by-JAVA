 class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i =0; i<m; i++){
            pq.add(nums1[i]);
        }

        for(int j = 0; j<n; j++){
            pq.add(nums2[j]);
        }

        // int[] ans = new int[n+m];
        int i = 0;
        while(!pq.isEmpty()){
            nums1[i] = pq.poll();
            i++;
        }
        // return ans;
    }
}
