class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;

        //first reverse full array:
        reverse(nums, 0, nums.length -1);

        //reverse only first k elements:
        reverse(nums, 0, k-1);

        //reverse everything after k:
        reverse(nums, k, nums.length - 1);
    }

    public static void reverse (int[] nums, int startIndex, int endIndex) {
       int left = startIndex; int right = endIndex;

       while (left < right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
        left++;
        right--;
       }
    }
}