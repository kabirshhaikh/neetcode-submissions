class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0;
        int zeroCount = 0;
        int output = 0;

        for (int right=0; right<nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            //shrink logic:
            while (zeroCount > 1) {
                //decrement zeroCount only if nums[left] is zero:
                if (nums[left] == 0) {
                    zeroCount--;
                }

                //increment left:
                left++;
            } 

            //capture window size:
            output = Math.max(output, right - left + 1);
        }

        return output;
    }
}

// so set two pointers:
// left on 0 and right starts from 0th index of nums.
// maintain a variable maybe called as zeroCount and set it to zero initially.
// initialize a variable output and set it as zero.

// run outer for loop:
// grab current element from nums[right], check if its zero
// if its zero -> increment zeroCount.

// while (zeroCount > 1) 
// first capture length of longest consecutive 1's by doing right - left + 1 which indicates the length of the window.
// then decrement zerCount--
// and then increment left pointer.

// at this point you exit out of the while loop.
// and the for loop continues.

// after the for loop is over, return output variable which hold the length of the longest consecutive 1's.

