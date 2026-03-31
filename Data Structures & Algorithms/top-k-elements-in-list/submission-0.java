class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        //here i count freq of each element:
        for (int i=0; i<nums.length; i++) {
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
        }

        //here i create a list which will hold map entry:
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>();

        //Here I add map entries into the list:
        for (Map.Entry<Integer, Integer> mapEntries : hashMap.entrySet()) {
            list.add(mapEntries);
        }

        //now i sort the list:
        list.sort((a, b) -> b.getValue() - a.getValue());

        //now i loop over list until less than k and enter they element in the output array:
        int[] output = new int[k];

        for (int i=0; i<k; i++) {
            Map.Entry<Integer, Integer> entry = list.get(i);
            output[i] = entry.getKey();
        }

        return output;
    }
}
