class Solution {
    public int[] findDuplicates(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            int curr = nums[i];
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            int key = m.getKey();
            int val = m.getValue();
            if (val == 2) {
                list.add(key);
            }
        }

        int[] output = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            output[i] = list.get(i);
        }

        return output;
    }

    //time complexity is: O(n)
    //space complexity: O(n)
    //add and getting from hashmap is in O(1) time
}
