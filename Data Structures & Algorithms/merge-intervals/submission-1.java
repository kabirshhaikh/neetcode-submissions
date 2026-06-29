class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        List<int[]> list = new ArrayList<>();

        int[] prev = intervals[0];

        for (int i=1; i<intervals.length; i++) {
            int[] current = intervals[i];
            int currentStartTime = current[0];
            int currentEndTime = current[1];

            int previousStartTime = prev[0];
            int previousEndTime = prev[1];

            if (currentStartTime <= previousEndTime) {
                prev[1] = Math.max(currentEndTime, previousEndTime);
            }
            else {
                list.add(prev);
                prev = current;
            }
        }

        list.add(prev);

        int[][] output = new int[list.size()][list.get(0).length];

        for (int i=0; i<list.size(); i++) {
            output[i] = list.get(i);
        }

        return output;
    }
}
