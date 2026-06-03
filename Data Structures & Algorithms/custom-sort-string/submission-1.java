class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> orderMap = new HashMap<>();

        StringBuilder sb = new StringBuilder();

        // sMap built:
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
        }

        // orderMap built:
        for (int i = 0; i < order.length(); i++) {
            char ch = order.charAt(i);
            orderMap.put(ch, orderMap.getOrDefault(ch, 0) + 1);
        }

        // building string:
        for (int i = 0; i < order.length(); i++) {
            char ch = order.charAt(i);
            if (sMap.containsKey(ch)) {
                int count = sMap.get(ch);
                for (int j = 0; j < count; j++) {
                    sb.append(ch);
                }
            }
        }

        // adding characters to string which are not present in order:
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!orderMap.containsKey(ch)) {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}