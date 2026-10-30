class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] prefixSum = new int[words.length];
        
        String firstWord = words[0];
        if (isWordVowel(firstWord)) {
            prefixSum[0] = 1;
        }
        else {
            prefixSum[0] = 0;
        }

        for (int i=1; i<words.length; i++) {
            String curr = words[i];
            if (isWordVowel(curr)) {
                prefixSum[i] = prefixSum[i-1] + 1;
            }
            else {
                prefixSum[i] = prefixSum[i-1] + 0;
            }
        }

        int[] output = new int[queries.length];
        for (int i=0; i<queries.length; i++) {
            int[] curr = queries[i];
            int start = curr[0];
            int end = curr[1];
            if (start == 0) {
                output[i] = prefixSum[end];
            }
            else {
                output[i] = prefixSum[end] - prefixSum[start - 1];
            }
        }

        return output;
    }

    public boolean isWordVowel (String word) {
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        return vowels.contains(word.charAt(0)) && vowels.contains(word.charAt(word.length() - 1));
    }
}