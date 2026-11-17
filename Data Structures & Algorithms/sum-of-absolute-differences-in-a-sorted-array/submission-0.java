class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        int totalSum = prefix[prefix.length - 1];
        int[] output = new int[nums.length];

        for (int i = 0; i < prefix.length; i++) {
            if (i == 0) {
                output[i] = (totalSum - nums[i]) - (nums[i] * (nums.length - 1));
            }
            else {
                int leftSum = prefix[i-1];
                int leftTotal = nums[i] * i - leftSum;
                int rightTotal = (totalSum - prefix[i]) - (nums[i] * (nums.length - i - 1));
                output[i] = leftTotal + rightTotal;
            }
        }

        return output;
    }
}
