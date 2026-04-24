class Solution {
    public boolean isSubsequence(String s, String t) {
        int sPointer = 0;
        int i = 0;

        for (i = 0; i < t.length(); i++) {
            if (sPointer < s.length() && t.charAt(i) == s.charAt(sPointer)) {
                sPointer++;
            }
        }

        if (sPointer == s.length()) {
            return true;
        } else {
            return false;
        }
    }
}