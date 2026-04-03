class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        for (int fast = 1; fast<nums.length; fast++) {
            //if a non duplicate element is found then:
            if (nums[slow] != nums[fast]) {
                //increment the slow pointer first:
                slow++;

                //and then copy the fast element into slow pointers position:
                nums[slow] = nums[fast];
            }
        }

        //here i return position of slow pointer + 1:
        return slow + 1;
    }
}
