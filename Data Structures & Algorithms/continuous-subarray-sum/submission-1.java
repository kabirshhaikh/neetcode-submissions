class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int[] prefix = getPrefixSum(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < prefix.length; i++) {
            int remainder = prefix[i] % k;

            if (map.containsKey(remainder) && i - map.get(remainder) >= 2) {
                return true;
            }

            if (!map.containsKey(remainder)) {
                map.put(remainder, i);
            }
        }

        return false;
    }

    private static int[] getPrefixSum(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];

        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = nums[i] + prefix[i - 1];
        }

        return prefix;
    }
}
