class Solution {
    public int longestConsecutive(int[] nums) {
        //here i initialize the set to hold all unique elements:
        HashSet<Integer> set = new HashSet<>();

        //here i initialize the variable with count as 0:
        int longestSequence = 0;

        //here i add all the numbers in set:
        for (int i=0; i<nums.length; i++) {
            set.add(nums[i]);
        }

        //now i loop over the set:
        for (int number : set) {
            int length = 1;
            int toCheckAgainst = number;

            //if currentNumber - 1 does not exists in set then that means
            //it is start of the sequence:
            if (!set.contains(toCheckAgainst - 1)) {
                //here i write while loop to keep checking for the next number with diff == 1:
                while (set.contains(toCheckAgainst + 1)) {
                    //if the set contains that element then i increment both the variables:
                    toCheckAgainst++;
                    length++;
                }

            //after while loop ends i check for max length of longestConsecutive sequence:
             longestSequence = Math.max(longestSequence, length);   
            }
        }
 
        return longestSequence;
    }
}
