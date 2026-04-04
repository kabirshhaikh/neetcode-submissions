class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //here i initialize the output list:
        List<List<Integer>> output = new ArrayList<>();

        //here i sort the array because that helps two pointers two compare elements on both ends:
        Arrays.sort(nums);

        //the outer most loop runs till less than nums.length - 3:
        for (int i=0; i<nums.length - 3; i++) {
            //if i > 0 and current ith element same as before then duplicate found and continue/increment ith pointer:
            if (i > 0 && nums[i] == nums[i-1]) continue;
            for (int j=i+1; j<nums.length - 2; j++) {
                //if j > i+1 and current jth element is same as before then duplicate found, which mean continue/increment jth pointer
                if (j > i+1 && nums[j] == nums[j-1]) continue;

                //inside second loop i initialize the left and right pointer:
                int left = j+1;
                int right = nums.length - 1;

                //the pointers run till left does not meet right:
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    //if sum == target
                    if (sum == (long) target) {
                        //then i create a temolist add those 4 elements and add temp to output:
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]); temp.add(nums[j]); temp.add(nums[left]); temp.add(nums[right]);
                        output.add(temp);

                        //after that i increment left and decrement right pointer:
                        left++;
                        right--;

                        //after that i make sure that current left pointer element is not same as before, if it is then i increment left pointer to avoid duplicate:
                        while (left < right && nums[left] == nums[left - 1]) left++;

                        //i do the same here with right, if duplicate is found then i decrement right pointer:
                        while (left < right && nums[right] == nums[right+1]) right--;
                    }
                    //if sum is less than target then increment left to maximize the search:
                    else if (sum < target) {
                        left++;
                    }
                    //if sum is greater than target then i decrement the right counter:
                    else {
                        right--;
                    }
                }
            }
        }

        //here i return the output list:
        return output; 
    }
}