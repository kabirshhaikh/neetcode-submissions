class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - 1;

        while (right - left + 1 > k) {
            int leftDist = Math.abs(arr[left] - x);
            int rightDist = Math.abs(arr[right] - x);

            if (leftDist > rightDist) {
                left++;
            } else {
                right--;
            }
        }

        List<Integer> output = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            output.add(arr[i]);
        }

        return output;
    }
}