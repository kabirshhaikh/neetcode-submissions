class Solution {
    public long countPairs(int[] nums1, int[] nums2) {
        int[] diff = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            diff[i] = nums1[i] - nums2[i];
        }

        Arrays.sort(diff);

        int left = 0;
        int right = diff.length - 1;
        long output = 0;

        while (left < right) {
            long sum = (long) diff[left] + diff[right];
            if (sum > 0) {
                output += right - left;
                right--;
            } else {
                left++;
            }
        }

        return output;
    }
}
