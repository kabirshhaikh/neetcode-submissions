class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long total = 0;

        for (int left=0; left<nums.length; left++) {
            if (nums[left] == 0) {
                int right = left;
                while (right < nums.length && nums[right] == 0) {
                    right++;
                }

                long length = right - left;
                total += (1L * length * (length + 1)) / 2;

                left = right - 1;
            }
        }

        return total;
    }
}