class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int subSeq = 0;

        int mod = 1_000_000_007;
        int[] pow = new int[nums.length];
        pow[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            pow[i] = (pow[i - 1] * 2) % mod;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                subSeq = (subSeq + pow[right - left]) % mod;
                left++;
            } else if (nums[left] + nums[right] > target) {
                right--;
            }
        }

        return subSeq;
    }
}