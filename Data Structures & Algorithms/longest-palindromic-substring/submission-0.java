class Solution {
    //for this problem i need to use expand around the center logic:
    //also i need to handle both odd and even length string situations:
    public String longestPalindrome(String s) {
        String longest = s.substring(0, 1);

        for (int i = 0; i < s.length(); i++) {
            //Odd length logic:
            int left = i - 1;
            int right = i + 1;

            String currentLongest = "";

            while (left >= 0 && right <= s.length() - 1) {
                char leftChar = s.charAt(left);
                char rightChar = s.charAt(right);

                if (leftChar == rightChar) {
                    // if valid then set currentLongest to valid substring:
                    currentLongest = s.substring(left, right + 1);

                    // then decrement left and increment right:
                    left--;
                    right++;
                } else {
                    break;
                }
            }

            if (currentLongest.length() > longest.length()) {
                longest = currentLongest;
            }

            //even length logic:
            left = i; right = i+1;

            while (left >= 0 && right <= s.length() - 1) {
                char leftChar = s.charAt(left);
                char rightChar = s.charAt(right);

                if (leftChar == rightChar) {
                    // if valid then set currentLongest to valid substring:
                    currentLongest = s.substring(left, right + 1);

                    // then decrement left and increment right:
                    left--;
                    right++;
                } else {
                    break;
                }
            }

            if (currentLongest.length() > longest.length()) {
                longest = currentLongest;
            }
        }

        return longest;
    }
}
