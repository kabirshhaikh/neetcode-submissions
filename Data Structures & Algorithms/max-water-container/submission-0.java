class Solution {
    public int maxArea(int[] heights) {
        //here i define an int variable output:
        int output = 0;

        //here i initialize the two pointers:
        int left = 0;
        int right = heights.length - 1;

        //both the pointers will walk towards each other until left < right:
        while (left < right) {
            //here i extract the heights of both the pointers/walls:
            int leftWall = heights[left];
            int rightWall = heights[right];

            //here i calculate the area: Widht * length:
            //right - left is width and min height wall is length:
            int area = (right - left) * Math.min(leftWall, rightWall);

            //then i compare the area with output variable:
            output = Math.max(output, area);

            //now time to decide which pointer to move:
            //if left wall smaller than right:
            if (leftWall < rightWall) {
                //then increment left:
                left++;
            }
            //if left wall greater then right:
            else if (leftWall > rightWall) {
                //then decrement right pointer:
                right--;
            }
            //otherwise if both heights are same then increment left and 
            //decrement right:
            else {
                left++;
                right--;
            }
        }

        //here i return the output variable:
        return output;
    }
}
