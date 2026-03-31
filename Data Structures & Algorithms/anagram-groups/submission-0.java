class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> anagram = new HashMap<>();
        List<List<String>> output = new ArrayList<>();

        for (int i=0; i<strs.length; i++) {
            String current = strs[i];
            int[] freq = new int[26];

            //here i record freq count of each char in array:
            for (int j=0; j<current.length(); j++) {
                char currentChar = current.charAt(j);
                freq[currentChar - 'a']++;
            }

            //here i make a string as hash of the freq array:
            String hash = Arrays.toString(freq);

        
            //here i get the value of hash if present otherwise it returns an empty list:
            List<String> valueList = anagram.getOrDefault(hash, new ArrayList<>());

            //here i add current word to returned list:
            valueList.add(current);

            //here i update/override the hashmap:
            anagram.put(hash, valueList);
        }

        for (List<String> value : anagram.values()) {
            output.add(value);
        }

        return output;
    }
}
