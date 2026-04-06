class Solution {
    public String mergeAlternately(String word1, String word2) {
        //here i initialize the string builder:
        StringBuilder sb = new StringBuilder();

        //here i start from 0 and go until the length of the shortest string:
        for (int i=0; i<Math.min(word1.length(), word2.length()); i++) {
            sb.append(word1.charAt(i)).append(word2.charAt(i));
        }

        //if word 1 is less than word 2 then start loop at word1.length() and run until < word2.length():
        if (word1.length() < word2.length()) {
            for (int i=word1.length(); i<word2.length(); i++) {
                sb.append(word2.charAt(i));
            }
        }
        //if word2.length() is less than word1.length():
        //word1 = "abcefgh", word2 = "xyz":
        //start the loop at word2.length() and run until word.length();
        else{
            for (int i=word2.length(); i<word1.length(); i++) {
                sb.append(word1.charAt(i));
            }
        }

        //return the sb.toString();
        return sb.toString(); 
    }
}