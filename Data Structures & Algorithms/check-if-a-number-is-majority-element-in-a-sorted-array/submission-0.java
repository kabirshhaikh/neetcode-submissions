class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        //first find the index of first occurrence of target:
        int left = 0; int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }

        int targetIndex = left;

        //at this point we found targetIndex:
        //now find index of next greater element than target:
        int low = 0; int high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= target) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }

        int greaterElementIndex = low;

        return greaterElementIndex - targetIndex > nums.length / 2;
    }
}
