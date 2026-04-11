class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0; int right = nums.length - 1;
        //-1, 0, 2, 4, 6, 8: l=3, r =3
        //3 + (3-3)/2 = mid 3 
        //so nums[mid=3] = element 4
        //since 4 < 5 left = mid+1 meaning index 4. thats where element is to be inserted
        //so return left:

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return left;
    }
}