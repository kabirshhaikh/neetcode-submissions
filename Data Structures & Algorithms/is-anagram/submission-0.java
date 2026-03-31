class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        //here i initalize the hashmaps:
        HashMap<Character, Integer> sCount = new HashMap<>();
        HashMap<Character, Integer> tCount = new HashMap<>();

        //here i insert the count of freq for each character:
        for (int i=0; i<s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            sCount.put(sChar, sCount.getOrDefault(sChar, 0) + 1);
            tCount.put(tChar, tCount.getOrDefault(tChar, 0) + 1);
        }

        //here i iterate over the entries of hashmap:
        for (Map.Entry<Character, Integer> entry : sCount.entrySet()) {
            char currentChar = entry.getKey();
            int count = entry.getValue();

            if (count != tCount.getOrDefault(currentChar, 0)) {
                return false;
            }
        }

        return true;
    }
}
