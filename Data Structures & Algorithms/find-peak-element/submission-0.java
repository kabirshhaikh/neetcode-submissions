class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0; int right = nums.length - 1;

        //low < high because when loop ends low == high and that will be the peak
        while (left < right) {
            int mid = left + (right - left) / 2;
             if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }

        return left;
    }
}

//so basically use binary search.
//get mid check if its neighbours are less than it then thats the index return mid.
//if mid is last element then compare with nums[mid - 1]
//if mid is first element then compare with nums[mid+1]
//else always compare with nums[mid - 1] < nums[mid] > nums[mid + 1]
//to move left and right pointer
//if nums[mid] > nums[mid] + 1 then do right = mid because mid can be peak.
//if nums[mid] < nums[mid + 1] then do left = mid + 1 because we know here mid is less than its neighbour so go right.
