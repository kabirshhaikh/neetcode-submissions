class Solution {
    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i=0; i<s.length(); i++) {
            char current = s.charAt(i);
            map.put(current, map.getOrDefault(current, 0) + 1);
        }

        int oddCount = 0;

        for (Map.Entry<Character, Integer> m : map.entrySet()) {
            char key = m.getKey();
            int val = m.getValue();
            if (val % 2 == 1) {
                oddCount++;
            }
        }

        return oddCount <= 1;
    }
}
