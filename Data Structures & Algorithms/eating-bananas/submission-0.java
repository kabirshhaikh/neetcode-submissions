class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1; int right = maxNum(piles);
       
        while (left <= right) {
            int k = left + (right - left)/2;
            boolean isFeasible = feasible(k, piles, h);

            if (isFeasible) {
                //if true then that means we can go lower so we go left:
                right = k - 1;
            }
            else {
                //if its not true then we need to increase the k so go right:
                left = k + 1;
            }
        }

        return left;
    }

    private static boolean feasible (int k, int[] piles, int h) {
        int output = 0;

        for (int i=0; i<piles.length; i++) {
            output = output + (piles[i] + k - 1)/k;
        }

        return output<=h;
    }

    private static int maxNum (int[] piles) {
        int max = -1;

        for (int i=0; i<piles.length; i++) {
            max = Math.max(piles[i], max);
        }

        return max;
    }
}
