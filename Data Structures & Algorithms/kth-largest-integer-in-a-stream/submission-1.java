class KthLargest {
    int[] nums;
    int k;
    PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = nums;
        pq = new PriorityQueue<>((a, b) -> a - b);

        for (int i=0; i<nums.length; i++) {
            pq.offer(nums[i]);
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        while (pq.size() > k) {
            pq.poll();
        }

        return pq.peek();
    }
}
