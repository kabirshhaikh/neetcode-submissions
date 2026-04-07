class Solution {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        //1,1,2,3,4:
        //2,1,2,3,4:
        //2,3,2,3,4:
        //2,3,4,3,4:
        //slow is at element 4 index 2:
        //so from 0 to 2 is the unique elements:
        for (int fast=0; fast<nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }

        return slow;
    }
}