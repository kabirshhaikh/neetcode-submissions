class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        for (int i=0; i<stones.length; i++) {
            pq.offer(stones[i]);
        }
        //2,2,3,4,6
        //6 and 4
        while (pq.size() > 1) {
            int x = pq.poll(); //remove and get x
            int y = pq.poll(); //remove and get y

            //if x == y both are destroyed and already removed so no worries:

            if (x != y) {
                pq.offer(Math.abs(y-x));
            }
        }

        return pq.isEmpty() ? 0 : pq.poll();
    }
}
