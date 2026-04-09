class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');

        for (int i=0; i<s.length(); i++) {
            char current = s.charAt(i);

            if (current == '[' || current == '{' || current == '(') {
                stack.push(current);
            }
            else if (stack.isEmpty() || map.get(current) != stack.pop()) {
                    return false;
            }
        
        }


        return stack.isEmpty();
    }
}
