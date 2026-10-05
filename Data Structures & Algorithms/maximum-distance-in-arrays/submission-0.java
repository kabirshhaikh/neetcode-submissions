class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int output = 0;

        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);

        for (int i=1; i<arrays.size(); i++) {
            List<Integer> curr = arrays.get(i);
            int currMin = curr.get(0);
            int currMax = curr.get(curr.size() - 1);

            int candidate1 = Math.abs(currMax - min);
            int candidate2 = Math.abs(currMin - max);

            output = Math.max(output, Math.max(candidate1, candidate2));

            //now update global min max:
            min = Math.min(min, currMin);
            max = Math.max(max, currMax);
        }

        return output;
    }
}
