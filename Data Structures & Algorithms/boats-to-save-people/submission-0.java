class Solution {
    public int numRescueBoats(int[] people, int limit) {
        //here i sort array so that two pointers can work well:
        Arrays.sort(people);
        //1,2,2,3,3:

        //here i initialize the two pointers which is left and right:
        int left = 0;
        int right = people.length - 1;

        //here i initialize the output counter variable:
        int output = 0;

        //the while loop runs until left and right doesn't meet:
        while (left <= right) {
            //here i calculate the sum from the elements of left and right pointer:
            int sum = people[left] + people[right];

            //if sum is less then limit or equal to meaning both left and right fit on the boat:
            if (sum <= limit) {
                left++;
                right--;
            }
            //if the sum is greater than limit then only decrement right:
            else {
                right--;
            }

            //no matter what output gets incremented:
            output++;
        }

        return output;
    }
}