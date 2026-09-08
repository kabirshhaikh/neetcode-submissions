class Solution {
    public int missingElement(int[] nums, int k) {
        int low = 0; int high = nums.length;

        while (low < high) {
            int mid = low + (high - low) / 2;
            int missing = nums[mid] - nums[0] - mid;

            if (missing >=k) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }

        return nums[0] + low + k - 1;
    }
}

// [4,7,9,10]
// low = 0, high = 4
// k = 3
// BODMAS
// iteration 1:
// mid = low + (high - low) / 2; => 0 + (4)/2 => 2
// nums[2] = 9; so at this point 6 numbers are missing because nums[2] should be 3. so 9-3 =6.

