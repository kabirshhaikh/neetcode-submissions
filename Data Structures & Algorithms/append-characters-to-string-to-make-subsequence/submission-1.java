class Solution {
    public int appendCharacters(String s, String t) {
        int i = 0; int j = 0;

        //s = "abxbc", t = "abc":

        while (i < s.length() && j < t.length() ) {
            if (s.charAt(i) == t.charAt(j)) {
                //if this is true then advance j for t string:
                j++;
            }

            //otherwise advance i:
            i++;
        }

        return t.length() - j;
    }
}