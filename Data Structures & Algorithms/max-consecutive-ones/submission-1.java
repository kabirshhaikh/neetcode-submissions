class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOnes = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                int right = i + 1;

                while (right < nums.length && nums[right] == 1) {
                    right++;
                }

                maxOnes = Math.max(maxOnes, right - i);
            }
        }

        return maxOnes;
    }
}