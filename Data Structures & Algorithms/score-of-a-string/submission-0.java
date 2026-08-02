class Solution {
    public int scoreOfString(String s) {
        int sum = 0;
        for (int i=1; i<s.length(); i++) {
            int curr = s.charAt(i);
            int prev = s.charAt(i-1);
            int diff = Math.abs(curr - prev);
            sum += diff;
        }

        return sum;
    }
}