class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> myMap = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            int currentNumber = nums[i];
            myMap.put(currentNumber, myMap.getOrDefault(currentNumber,0) + 1);
        }

        for (Map.Entry<Integer, Integer> map : myMap.entrySet()) {
            int count = map.getValue();
            if (count > 1) {
                return true;
            }
        }
        return false;
    }
}
