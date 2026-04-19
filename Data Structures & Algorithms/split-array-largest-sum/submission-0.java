class Solution {
    public int splitArray(int[] nums, int k) {
        int left = getMaxElement(nums);
        int right = getSum(nums);

        while (left <= right) {
            int mid = left + (right - left) / 2;
            boolean isFeasible = feasible(mid, nums, k);
            if (isFeasible) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public boolean feasible(int target, int[] nums, int k) {
        int subarrays = 1;
        int runningSum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (runningSum + nums[i] > target) {
                subarrays++;
                runningSum = nums[i];
            } else {
                runningSum += nums[i];
            }
        }

        if (subarrays <= k) {
            return true;
        } else {
            return false;
        }
    }

    public int getMaxElement(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        return max;
    }

    public int getSum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        return sum;
    }
}