class Solution {
    public String stringShift(String s, int[][] shift) {
        for (int i=0; i<shift.length; i++) {
            int[] curr = shift[i];
            int dir = curr[0];
            int amount = curr[1];
            while (amount > 0) {
                //left dir:
                //remove first char and append to last:
                if (dir == 0) {
                    char ch = s.charAt(0);
                    s = s.substring(1);
                    s = s + ch;
                    amount--;
                }

                //if 1 then take last character and append in the beginning:
                if (dir == 1) {
                    char ch = s.charAt(s.length() - 1);
                    s = s.substring(0, s.length() - 1);
                    s = ch + s;
                    amount--;
                }
            }
        }

        return s;
    }
}
