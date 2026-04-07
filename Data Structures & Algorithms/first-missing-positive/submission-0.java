class Solution {
    public int firstMissingPositive(int[] nums) {
        //this approach is O(n)space and O(n)time:
        // HashSet<Integer> set = new HashSet<>();

        // for (int i=0; i<nums.length; i++) {
        //     set.add(nums[i]);
        // }

        // for (int i=1; i<nums.length + 1; i++) {
        //     if (!set.contains(i)) {
        //         return i;
        //     }
        // }

        // return nums.length + 1;


        //for O(n) time and O(1) space I will use index marking while looping on the array nums:
        //i will mark the values as -ve:

        //first i am replacing all negative numbers with a placeholder value because they are useless:
        for (int i=0; i<nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = nums.length + 1;
            }
        }

        for (int i=0; i<nums.length; i++) {
            int currentVal = Math.abs(nums[i]);

            if (currentVal >=1 && currentVal <= nums.length) {
                nums[currentVal - 1] = -Math.abs(nums[currentVal - 1]);
            }
        }

        for (int i=0; i<nums.length; i++) {
            if (nums[i] > 0) {
                return i+1;
            }
        }

        return nums.length + 1;
    }
}