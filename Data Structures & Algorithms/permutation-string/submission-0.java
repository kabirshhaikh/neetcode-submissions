class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> s1Map = new HashMap<>();
        for (int i=0; i<s1.length(); i++) {
            s1Map.put(s1.charAt(i), s1Map.getOrDefault(s1.charAt(i), 0) + 1);
        }

        HashMap<Character, Integer> s2Map = new HashMap<>();
        int left = 0;

        for (int right=0; right<s2.length(); right++) {
            char charToAdd = s2.charAt(right);

            //add:
            s2Map.put(charToAdd, s2Map.getOrDefault(charToAdd, 0) + 1);

            //shrink:
            while (right - left + 1 > s1.length()) {
                char charToBeRemoved = s2.charAt(left);
                s2Map.put(charToBeRemoved, s2Map.get(charToBeRemoved) - 1);
                if (s2Map.get(charToBeRemoved) == 0) s2Map.remove(charToBeRemoved);
                left++;
            }

            //return true if permuation found:
            if (s1Map.equals(s2Map)) {
                return true;
            }
        } 

        return false;
    }
}
