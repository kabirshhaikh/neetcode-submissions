class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        //[2,3,1,5,4] -> before
        //[5,4,3] ->pq after
        for (int i=0; i<nums.length; i++) {
            int current = nums[i];
            pq.offer(current);
            while (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();
    }
}
