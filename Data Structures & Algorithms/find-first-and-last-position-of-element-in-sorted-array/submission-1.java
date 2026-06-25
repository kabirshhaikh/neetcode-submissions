class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1,-1};
        }
        int[] output = new int[2];

        //here i am defining the two pointer to find the left most occurrence of target (meaning first):
        int low = 0; int high = nums.length;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }

        int firstNumber = low < nums.length && nums[low] == target ? low : -1;

        //here i am resetting the pointer to find the right most occurrence of target:
        low = 0; high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            if (nums[mid] <= target) {
                low = mid;
            }
            else {
                high = mid - 1;
            }
        }

        int secondNumber = high < nums.length && nums[high] == target ? high : -1;

        output[0] = firstNumber;
        output[1] = secondNumber;

        return output;
    }
}





