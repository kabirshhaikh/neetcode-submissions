class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[1] - x[1]);

        if (a > 0)
            pq.offer(new int[] {'a', a});
        if (b > 0)
            pq.offer(new int[] {'b', b});
        if (c > 0)
            pq.offer(new int[] {'c', c});

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int length = sb.length();

            // if the length of top is => 2 and prev 2 chars are same as 0th index element then we
            // cannot add that char:
            if (length >= 2 && sb.charAt(length - 1) == top[0] && sb.charAt(length - 2) == top[0]) {
                // then before popping another element we check if pq is empty or not:
                if (pq.isEmpty())
                    break;

                // pop second top most array:
                int[] second = pq.poll();

                // add the char:
                sb.append((char) second[0]);

                // decrement the count of that char:
                second[1]--;

                // if second still have count remaing then add the decremented second array into pq
                // again:
                if (second[1] > 0) {
                    pq.offer(second);
                }

                // put top back:
                pq.offer(top);
            } else {
                sb.append((char) top[0]);
                top[1]--;
                if (top[1] > 0) {
                    pq.offer(top);
                }
            }
        }

        return sb.toString();
    }
}