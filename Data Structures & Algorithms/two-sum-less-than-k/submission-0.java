class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;

        int output = -1;

        //1, 8, 23, 24, 33, 34, 54, 75

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < k) {
                output = Math.max(output, sum);
                left++;
            }
            else {
                right--;
            }
        }

        return output;
    }
}
