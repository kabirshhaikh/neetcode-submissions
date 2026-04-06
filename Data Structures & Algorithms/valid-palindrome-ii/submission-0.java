class Solution {
    public boolean validPalindrome(String s) {
        //first i initialize two variables: l for left and r for right:
        int l=0; int r=s.length()-1;

        //now i walk these pointers towards each other:
        while (l < r) {
            //if charcter mismatch then i use helper method which basically check left + 1 till r and right -1 till l:
            //if both are false then i return false, if even one is true then i return true:
            if (s.charAt(l) != s.charAt(r)) {
                boolean leftPlusOne = isPalindrome(s, l+1, r);
                boolean rightMinusOne = isPalindrome(s, l, r-1);

                if (!leftPlusOne && !rightMinusOne) {
                    return false;
                }
                else {
                    return true;
                }
            }

            //otherwise i just increment l and decrement r:
            l++;
            r--;
        }

        return true;
    }

    //this is the helper method:
    public static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}