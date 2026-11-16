class Solution {
    public int equalDigitFrequency(String s) {
        HashSet<String> seen = new HashSet<>();

        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            HashMap<Character, Integer> map = new HashMap<>();
            StringBuilder sb = new StringBuilder();

            for (int j = i; j < s.length(); j++) {
                char ch = s.charAt(j);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                sb.append(ch);

                int value = -1;
                boolean isSame = true;

                // now check if all the frequencies are valid:
                for (Map.Entry<Character, Integer> m : map.entrySet()) {
                    int val = m.getValue();
                    if (value == -1) {
                        value = val;
                        continue;
                    }

                    if (value != val) {
                        isSame = false;
                        break;
                    }
                }

                if (isSame && !seen.contains(sb.toString())) {
                    count++;
                    seen.add(sb.toString());
                }
            }
        }

        return count;
    }
}
