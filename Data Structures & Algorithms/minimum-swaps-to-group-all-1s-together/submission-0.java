class Solution {
    public int minSwaps(int[] data) {
        int windowSize = 0;
        for (int i=0; i<data.length; i++) {
            if (data[i] == 1) {
                windowSize++;
            }
        }

        if (windowSize == 0) {
            return 0;
        }

        int minSwap = Integer.MAX_VALUE;
        
        //at this point we have a fixed variable windowsize:
        //each 0 accounts for a swap, so now i will count minimum number of zeros in a window:
        int initialCountOfZeros = 0;
        for (int i=0; i<windowSize; i++) {
            if (data[i] == 0) {
                initialCountOfZeros++;
            }
        }

        minSwap = Math.min(minSwap, initialCountOfZeros);

        for (int i=windowSize; i<data.length; i++) {
            int leavingElement = data[i - windowSize];
            int enteringElement = data[i];
            if (leavingElement == 0) {
                initialCountOfZeros--;
            }
            if (enteringElement == 0) {
                initialCountOfZeros++;
            }

            minSwap = Math.min(initialCountOfZeros, minSwap);
        }

        return minSwap;
    }
}
