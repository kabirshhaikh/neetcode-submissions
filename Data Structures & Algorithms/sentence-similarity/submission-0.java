class Solution {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) {
            return false;
        }

        HashSet<List<String>> similarSet = new HashSet<>();

        for (int i=0; i<similarPairs.size(); i++) {
            List<String> curr = similarPairs.get(i);
            similarSet.add(curr);
        }

        for (int i=0; i<sentence1.length; i++) {
            String word1 = sentence1[i];
            String word2 = sentence2[i];

            if (!word1.equals(word2)) {
                List<String> temp1 = Arrays.asList(word1, word2);
                List<String> temp2 = Arrays.asList(word2, word1);
                if (!similarSet.contains(temp1) && !similarSet.contains(temp2)) {
                    return false;
                }
            }
        }

        return true;
    }
}
