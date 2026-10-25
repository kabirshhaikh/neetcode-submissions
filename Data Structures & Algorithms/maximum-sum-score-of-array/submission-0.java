class Solution {
    public long maximumSumScore(int[] nums) {
        long[] prefix = new long[nums.length];
        long[] suffix = new long[nums.length];

        //prefix: [5, -4, 2]
        prefix[0] = nums[0];
        for (int i=1; i<nums.length; i++) {
            prefix[i] = nums[i] + prefix[i-1];
        }

        //suffix: [2,-3,6]
        suffix[suffix.length - 1] = nums[nums.length - 1];
        for (int i=nums.length - 2; i>=0; i--) {
            suffix[i] = suffix[i+1] + nums[i];
        }

        long output = Long.MIN_VALUE;

        for (int i=0; i<nums.length; i++) {
            output = Math.max(output, Math.max(prefix[i], suffix[i]));
        }

        return output;
        //prefix: [5, -4, 2]
        //suffix: [2,-3,6]
        //greatest from both index in suffix and prefix   : [5, -3, 6]
        //so all time greatest is 6 index 2.
    }
}
