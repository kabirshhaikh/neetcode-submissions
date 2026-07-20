class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            int[] curr = matrix[i];

            //if this is true then look into it:
            if (target >= curr[0] && target <= curr[curr.length - 1]) {
                int low = 0;
                int high = curr.length - 1;

                while (low <= high) {
                    int mid = low + (high - low) / 2;
                    if (curr[mid] == target) {
                        return true;
                    } else if (curr[mid] > target) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
            }
        }

        return false;
    }
}
