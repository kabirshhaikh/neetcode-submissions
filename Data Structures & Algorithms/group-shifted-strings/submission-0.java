class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> output = new ArrayList<>();

        for (int i = 0; i < strings.length; i++) {
            String current = strings[i];

            StringBuilder sb = new StringBuilder();

            for (int j = 1; j < current.length(); j++) {
                char prev = current.charAt(j - 1);
                char next = current.charAt(j);

                int sum = ((next - prev) + 26) % 26;
                sb.append(String.valueOf(sum)).append(",");
            }

            List<String> temp = map.getOrDefault(sb.toString(), new ArrayList<>());

            temp.add(current);
            map.put(sb.toString(), temp);
        }

        for (Map.Entry<String, List<String>> m : map.entrySet()) {
            String key = m.getKey();
            List<String> value = m.getValue();
            output.add(value);
        }

        return output;
    }
}
