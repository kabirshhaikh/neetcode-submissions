class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] output = new int[nums.length];

        for (int i=0; i<nums.length; i++) {
            int square = nums[i] * nums[i];
            output[i] = square;
        }

        Arrays.sort(output);

        return output;
    }
}