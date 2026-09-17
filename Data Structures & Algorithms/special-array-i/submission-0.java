class Solution {
    public boolean isArraySpecial(int[] nums) {
        for (int i=0; i<nums.length - 1; i++) {
            int curr = nums[i];
            int next = nums[i+1];

            if ((curr % 2 == 0 && next % 2 == 0) || (curr % 2 != 0 && next % 2 != 0)) {
                return false;
            }
        }

        return true;
    }
}