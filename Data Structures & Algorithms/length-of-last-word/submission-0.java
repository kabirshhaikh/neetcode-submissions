class Solution {
    public int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        String word = words[words.length - 1];
        return word.length();
    }
}