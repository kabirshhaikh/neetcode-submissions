class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int runningSum = 0;
        int left = 0;
        int minimal = Integer.MAX_VALUE;

        for (int right=0; right<nums.length; right++) {
            //add current number to runningSum:
            runningSum += nums[right];

            //not sure about shrink condition while valid:
            while (runningSum >= target) {
                //record the length: 
                minimal = Math.min(minimal, right - left + 1);

                //subtract the value of left from runningSum:
                runningSum -= nums[left];

                //increment left:
                left++;
            }
        }

        return minimal == Integer.MAX_VALUE ? 0 : minimal;
    }
}