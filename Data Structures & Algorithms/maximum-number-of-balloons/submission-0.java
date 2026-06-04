class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> balloonMap = new HashMap<>();
        HashMap<Character, Integer> textMap = new HashMap<>();

        String s = "balloon";
        int min = Integer.MAX_VALUE;
        
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            balloonMap.put(ch, balloonMap.getOrDefault(ch, 0) + 1);
        }

        for (int i=0; i<text.length(); i++) {
            char ch = text.charAt(i);
            textMap.put(ch, textMap.getOrDefault(ch, 0) + 1);
        }

        for (Map.Entry<Character, Integer> m : balloonMap.entrySet()) {
            char key = m.getKey();
            int count = m.getValue();
            if (!textMap.containsKey(key)) {
                return 0;
            }

            int div = textMap.get(key) / count;
            min = Math.min(min, div);
        }

        return min;
    }
}