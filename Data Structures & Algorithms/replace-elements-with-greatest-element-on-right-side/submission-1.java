class Solution {
    public int[] replaceElements(int[] arr) {
        int[] output = new int[arr.length];
        int maxSoFar = arr[arr.length - 1];

        for (int i = arr.length - 2; i >= 0; i--) {
            output[i] = maxSoFar;
            maxSoFar = Math.max(maxSoFar, arr[i]);
        }

        output[output.length - 1] = -1;

        return output;
    }
}