class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        
        for (int i=1; i<nums.length; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        //[4, 9, 9, 7, 4, 5]

        int count = 0;

        for (int i=0; i<prefix.length; i++) {
            int remainder = ((prefix[i] % k) + k) % k;
            int val = map.getOrDefault(remainder, 0);
            count += val;
            map.put(remainder, val + 1);
        }

        // for (int left=0; left<nums.length; left++) {
        //     for (int right=left; right<nums.length; right++) {
        //         //if left index is 0 then use prefix[right] else use prefix[right]-prefix[left]
        //         int sum = (left == 0) ? prefix[right] : prefix[right] - prefix[left-1]; 
        //         if (sum % k == 0) {
        //             count++;
        //         }
        //     }
        // }

        return count;
    }
}

