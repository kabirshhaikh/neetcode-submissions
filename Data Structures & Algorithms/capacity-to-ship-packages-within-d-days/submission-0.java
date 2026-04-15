class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0; int right = 0;
        for (int i=0; i<weights.length; i++) {
            left = Math.max(left, weights[i]);
            right = right + weights[i];
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            boolean isPossible = isFeasible(weights, mid, days);
            if (isPossible) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return left;
    }

    public boolean isFeasible (int[] weights, int capacity, int days) {
        int currentLoad = 0;
        int totalDays = 1;

        for (int i=0; i<weights.length; i++) {
            if (currentLoad + weights[i] > capacity) {
                currentLoad = weights[i];
                totalDays++;
            }
            else {
                currentLoad = currentLoad + weights[i];
            }
        }

        return totalDays <= days;
    }
}