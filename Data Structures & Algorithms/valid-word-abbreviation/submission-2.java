class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int wordPointer = 0;

        for (int i = 0; i < abbr.length(); i++) {
            if (Character.isDigit(abbr.charAt(i))) {
                if (abbr.charAt(i) == '0') {
                    return false;
                }

                StringBuilder sb = new StringBuilder();
                int right = i;
                while (right < abbr.length() && Character.isDigit(abbr.charAt(right))) {
                    sb.append(abbr.charAt(right));
                    right++;
                }

                int numbersToSkip = Integer.parseInt(sb.toString());
                wordPointer = wordPointer + numbersToSkip;
                i = right - 1;
            } else {
                if (wordPointer >= word.length() || abbr.charAt(i) != word.charAt(wordPointer)) {
                        return false;
                    }
                else {
                    wordPointer++;
                }
            }
        }

        return wordPointer == word.length();
    }
}