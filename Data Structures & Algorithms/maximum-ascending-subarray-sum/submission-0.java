class Solution {
    public int maxAscendingSum(int[] nums) {
        int maxSum = 0;

        for (int i=0; i<nums.length; i++) {
            int j = i+1;
            int runningSum = nums[i];
            while (j < nums.length && nums[j] > nums[j-1]) {
                runningSum += nums[j];
                j++;
            }

            maxSum = Math.max(maxSum, runningSum);

            //now i update the ith counter.
            //[10,20,30,5,10,50]
            //lets say i start at 0th index and j breaks at 3, so after updating
            //maxSum i will set i to j-1 because when loop increments it should start at jth index where it broke, thats the logic i am using.

            i = j-1;
        }

        return maxSum;
    }
}