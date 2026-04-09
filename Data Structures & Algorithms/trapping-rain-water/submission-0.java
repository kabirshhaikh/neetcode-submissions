class Solution {
    public int trap(int[] height) {
        int leftMax = height[0];
        int rightMax = height[height.length - 1];

        int output = 0;

        int left = 0; int right = height.length - 1;

        while (left < right) {
            int leftNumber = height[left];
            int rightNumber = height[right];
            leftMax = Math.max(leftNumber, leftMax);
            rightMax = Math.max(rightNumber, rightMax);

            if (leftMax < rightMax) {
                output = output + leftMax - height[left];
                left++;
            }
            else {
                output = output + rightMax - height[right];
                right--;
            }
        }

        return output;
    }
}
