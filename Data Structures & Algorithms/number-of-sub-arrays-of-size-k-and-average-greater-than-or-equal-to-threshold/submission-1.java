class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        int sum = 0;

        for (int i=0; i<k; i++) {
            sum += arr[i];
        }

        if (sum / k >= threshold) {
            count++;
        }

        for (int i=k; i<arr.length; i++) {
            int numberToRemove = arr[i-k];
            sum = sum - numberToRemove;
            int numberToAdd = arr[i];
            sum = sum + numberToAdd;

            if (sum / k >= threshold) {
                count++;
            }
        }

        return count;
    }
}

