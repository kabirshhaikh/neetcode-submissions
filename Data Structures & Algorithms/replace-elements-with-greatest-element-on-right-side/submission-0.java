class Solution {
    public int[] replaceElements(int[] arr) {
        int[] output = new int[arr.length];

        for (int i = 0; i < arr.length - 1; i++) {
            int greaterElementOnRight = greatest(arr, i + 1);
            output[i] = greaterElementOnRight;
        }

        output[arr.length - 1] = -1;

        return output;
    }

    public int greatest(int[] arr, int start) {
        int output = Integer.MIN_VALUE;

        for (int i = start; i < arr.length; i++) {
            output = Math.max(output, arr[i]);
        }

        return output;
    }
}