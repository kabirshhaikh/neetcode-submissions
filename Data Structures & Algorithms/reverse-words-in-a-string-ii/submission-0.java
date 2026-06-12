class Solution {
    public void reverseWords(char[] s) {
        reverse(s);

        int start = 0;

        for (int end = 0; end < s.length; end++) {
            if (s[end] == ' ') {
                reverseWord(s, start, end - 1);
                start = end + 1;
            }
        }

        reverseWord(s, start, s.length - 1);
    }

    private void reverseWord(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

    private void reverse(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
