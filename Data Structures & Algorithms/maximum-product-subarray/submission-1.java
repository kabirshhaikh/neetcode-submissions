class Solution {
    public int maxProduct(int[] nums) {
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int maximumProduct = nums[0];

        for (int i=1; i<nums.length; i++) {
            int curr = nums[i];
            int tempMax = maxSoFar;
            int tempMin = minSoFar;
            maxSoFar = Math.max(nums[i], Math.max(tempMax * curr, tempMin * curr));
            minSoFar = Math.min(nums[i], Math.min(tempMax * curr, tempMin * curr));
            maximumProduct = Math.max(maximumProduct, maxSoFar);
        }

        return maximumProduct;
    }
}
