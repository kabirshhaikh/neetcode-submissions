class Solution {
    public int maxLength(int[] ribbons, int k) {
        int low = 1; int high = maxElement(ribbons);

        //edge case:
        if (!isFeasible(1, ribbons, k)) {
            return 0;
        }

        while (low < high) {
            int mid = low + (high - low + 1) / 2; //ceiling mid to avoid infinite loop
            boolean feasible = isFeasible(mid, ribbons, k);
            if (feasible) {
                low = mid;
            }
            else {
                high = mid - 1;
            }
        }

        return high;
    }

    private boolean isFeasible (int ribbonLength, int[] ribbons, int k) {
        int count = 0;

        for (int i=0; i<ribbons.length; i++) {
            int currRibbon = ribbons[i];
            int ans = currRibbon / ribbonLength;
            count = count + ans;
        }

        return count >= k;
    }

    private int maxElement (int[] arr) {
        int max = 0;
        for (int i=0; i<arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        return max;
    }
}
