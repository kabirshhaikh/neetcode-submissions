class Solution {
    public String longestCommonPrefix(String[] strs) {
        //here i initialize an empty output string:
        String longest = "";

        if (strs.length == 1) {
            return strs[0];
        }

        for (int i=1; i<strs.length; i++) {
            //here i initialize a string builder to compare the characters from current and prev word:
            StringBuilder sb = new StringBuilder();

            //here i extract current and previous word:
            String current = strs[i];
            String prev = strs[i-1];

            //here i initialize two pointers p1 and p2:
            int p1 = 0; int p2 = 0;

            //p1 runs until less than length of current word:
            //p2 runs until less than length of prev word: 
            while (p1 < current.length() && p2 < prev.length()) {
                char charAtP1 = current.charAt(p1);
                char charAtP2 = prev.charAt(p2);

                //if the charcters in both strings are same then i append it to string builder and inrement pointers:
                if (charAtP1 == charAtP2) {
                    sb.append(charAtP1);
                    p1++;
                    p2++;
                }
                //otherwise i break the while loop:
                else{
                    break;
                }
            }

            //this is the make or break:
            //if i == 1 because if starts from index 1 in for loop. I want it to overwrite the longest variable with sb.toString() because longest is initialized as empty string "":
            //moving forward, i update/overwrite longest only if sb.toString's length is less than longest variables length:
            if (i == 1 || sb.toString().length() < longest.length()) {
                longest = sb.toString();
            }
        }

        return longest;
    }
}