class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));

        for (int i = 0; i < points.length; i++) {
            int[] current = points[i];
            pq.offer(current);
            while (pq.size() > k) {
                pq.poll();
            }
        }

        List<int[]> list = new ArrayList<>();

        while (!pq.isEmpty()) {
            list.add(pq.poll());
        }

        int[][] output = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            output[i] = list.get(i);
        }

        return output;
    }
}
