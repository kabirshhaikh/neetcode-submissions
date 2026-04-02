class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;

        //Was it a car or a cat I saw?

        while (left < right) {
            //here i am going to skip left characters until its alphanumeric:
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            //here i am going to reduce right characters until its alphanumeric:
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
