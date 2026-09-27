class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        //edge case:
        if (k <= 1) {
            return 0;
        }

        int left = 0;
        int output = 0;
        int runningProduct = 1;

        for (int right=0; right<nums.length; right++) {
            //multiply current number with runningProduct:
            runningProduct = runningProduct * nums[right];
            
            //while running product = or more than k then thats an invalid wndow:
            //so divide runningProduct by number on left and then increment left:
            //need while loop here not if, if just removes one time, while keeps running
            //until window is valid again:
            while (runningProduct >= k) {
                //remove nums[left] from runningProduct by dividing:
                runningProduct = runningProduct / nums[left];

                //then increment left:
                left++;
            }
        
            //otherwise:
            output = output + right - left + 1;
        }

        return output;
    }
}