class Solution {
    public int maxDifference(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int oddCount = 0;
        int evenCount = Integer.MAX_VALUE;

        for (Map.Entry<Character, Integer> m : map.entrySet()) {
            char key = m.getKey();
            int value = m.getValue();

            if (value % 2 == 1) {
                oddCount = Math.max(oddCount, value);
            }
            else {
                evenCount = Math.min(evenCount, value);
            }
        }

        return oddCount - evenCount;
    }
}