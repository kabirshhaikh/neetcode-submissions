class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        // if mid = 0, then swap with low and move both mid and low
        // if mid = 1, then just increment mid
        // if mid = 2, then swap with high and decrement high
        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;

                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;
            }
        }
    }
}

// class Solution {
//     public void sortColors(int[] nums) {
//         int zeroes = 0;
//         int ones = 0;
//         int twos = 0;
//         int index = 0;

//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] == 0) {
//                 zeroes++;
//             } else if (nums[i] == 1) {
//                 ones++;
//             } else {
//                 twos++;
//             }
//         }

//         for (int i = 0; i < zeroes; i++) {
//             nums[index] = 0;
//             index++;
//         }

//         for (int i = 0; i < ones; i++) {
//             nums[index] = 1;
//             index++;
//         }

//         for (int i = 0; i < twos; i++) {
//             nums[index] = 2;
//             index++;
//         }
//     }
// }