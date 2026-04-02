class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //first i sort the array:
        //so that the next number will always be bigger than before and that
        //will help me calculate the target correctly.
        //if the array is not sorted then moving left and right pointer becomes difficult
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();

        for (int i=0; i<nums.length - 2; i++) {
            //here i skip the duplicate for index i:
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i+1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                //if target found then add elements into temp list and add to output:
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[i]); temp.add(nums[left]); temp.add(nums[right]);
                output.add(temp);
                left++;
                right--;

                //after moving pointers, i skip the duplicates for both left:
                while (left < right && nums[left - 1] == nums[left]) left++;

                //and right:
                while (left < right && nums[right] == nums[right + 1]) right--;
            }
            else if (sum < 0) {
                left++;
            }
            else if (sum > 0) {
                right--;
            }
            }
        }

        return output;
    }
}
