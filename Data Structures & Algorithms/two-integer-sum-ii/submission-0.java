class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //here i define two pointers:
        int left = 0;
        int right = numbers.length - 1;

        //here i initialize the output array of size 2:
        int[] output = new int[2];

        //i run the while loop and let the pointers walk towards eachother:
        //until left less than right:
        while (left < right) {
            //here i calculate the sum:
            int sum = numbers[left] + numbers[right];
            
            //if the sum equals the target then input the ans into output array 
            //as index + 1 since thats the requirement:
            if (sum == target) {
                output[0] = left + 1;
                output[1] = right + 1;

                //and then return the array:
                return output;
            }
            //if sum is less than target then increment left:
            //to increase the sum value and get close to value:
            else if (sum < target) {
                left++;
            }
            //otherwise decrement the right pointer:
            else {
                right--;
            }
        }  

        //here i return the output:
        return output;
    }
}
