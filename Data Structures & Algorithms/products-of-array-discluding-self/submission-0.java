class Solution {
    public int[] productExceptSelf(int[] nums) {
        //here i will build two arrays prefix and suffix:
        //prefix will hold product of values for LEFT side:
        //suffix will hold product of values for RIGHT side:
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];

        int[] suffix = new int[nums.length];
        suffix[suffix.length - 1] = nums[nums.length - 1];

        //here i am building prefix:
        for (int i=1; i<nums.length; i++) {
            prefix[i] = nums[i] * prefix[i-1];
        }

        //here i built suffix:
        for (int i=nums.length - 2; i>=0; i--) {
            suffix[i] = nums[i] * suffix[i+1];
        }

        //output array:
        int[] output = new int[nums.length];
        output[0] = suffix[1];
        output[output.length - 1] = prefix[prefix.length - 2];

        //output = [60, 40, 30, 24]

        //prefix products = [2, 6, 24, 120]
        //suffix products = [120, 60, 20, 5]
        for (int i=1; i<=nums.length - 2; i++) {
            int numberOnLeft = prefix[i-1]; 
            int numberOnRight = suffix[i+1];
            output[i] = numberOnLeft * numberOnRight;
        }

        return output;
    }
}  
