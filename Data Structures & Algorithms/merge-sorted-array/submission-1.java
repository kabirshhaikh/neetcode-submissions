class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //[10,20,20,40,0,0]
        //[1,2]:

        int p1 = m-1; //meaning start at element 40 of nums1:
        int p2 = n-1; //start at element2 of nums2:
        int p3 = nums1.length - 1;

        while (p1 >= 0 || p2 >= 0) {
            if (p1 >= 0 && (p2 < 0 || nums1[p1] > nums2[p2])) {
                nums1[p3] = nums1[p1];
                 p1--;
                 p3--;
            }
            else {
                nums1[p3] = nums2[p2];
                p2--;
                p3--;
            }
        }
    }
}