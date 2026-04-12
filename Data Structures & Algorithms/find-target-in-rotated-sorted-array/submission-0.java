class Solution {
    public int search(int[] nums, int target) {
        int left = 0; int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[left] <= nums[mid] && target >= nums[left] && target <= nums[mid]) {
                right = mid - 1;
            }
            else if (nums[mid] <= nums[right] && target >= nums[mid] && target <= nums[right]) {
                left = mid + 1;
            }
            else if (nums[left] <= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
