class Solution {
    public int largestUniqueNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int output = -1;

        for (int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            int key = m.getKey();
            int value = m.getValue();

            if (value == 1 && key > output) {
                output = key;
            }
        }

        return output;
    }
}
