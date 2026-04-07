class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int runningSum = 0;
        int result = 0;

        //add running sum as 0 with count 1:
        map.put(runningSum, 1);

        for (int i=0; i<nums.length; i++) {
            //get current runningSum:
            runningSum = runningSum + nums[i];

            //value which we are looking for in the map.
            //if it exists then that many subarrays exists so far for the K value.
            int lookingFor = runningSum - k;

            //does lookingFor exists in the map? if yes then get its count and increment result:
            result = result + map.getOrDefault(lookingFor, 0);

            //put the runningSum into the map and increment its count/value:
            map.put(runningSum, map.getOrDefault(runningSum, 0) + 1);
        }

        //here i return the result:
        return result;
    }
}