class Solution {
    public long countBadPairs(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        //this is brute force approach:
        // for (int i=0; i<nums.length; i++) {
        //     for (int j=i+1; j<nums.length; j++) {
        //         if (j - i != nums[j] - nums[i]) {
        //             output++;
        //         }
        //     }
        // }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            int key = nums[i] - i;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        long n = nums.length;
        long totalPairs = n * (n-1) / 2;

        //now i will calculate good pairs:
        long goodPairs = 0;

        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            int value = m.getValue();
            goodPairs += (long) value * (value - 1) /2;
        }

        return totalPairs - goodPairs;
    }
}

// nums = [4, 1, 3, 3]

// {
//     4-0i = 4
//     1-1i = 0
//     3-2i = 1
//     3-3i = 0   
// }

// so 0 diff occured two times.
// 1 diff occured 1 time 
// and 4 diff occured 1 time

// so map will look like this maybe:
// {
//     0 -> 2
//     1 -> 1
//     4 -> 1
// }
