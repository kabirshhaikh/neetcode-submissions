class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> output = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (m.getValue() > nums.length / 3) {
                output.add(m.getKey());
            }
        }

        return output;
    }
}