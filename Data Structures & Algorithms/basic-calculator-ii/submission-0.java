class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        char sign = '+';
        int output = 0;

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            if (Character.isDigit(current)) {
                // building multiple number string:
                StringBuilder sb = new StringBuilder();
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    sb.append(s.charAt(i));
                    i++;
                }

                // adjustment:
                i--;

                int currentNumber = Integer.parseInt(sb.toString());

                if (sign == '+')
                    stack.push(currentNumber);
                else if (sign == '-')
                    stack.push(-currentNumber);

                else if (sign == '*') {
                    stack.push(stack.pop() * currentNumber);
                } else if (sign == '/') {
                    stack.push(stack.pop() / currentNumber);
                }
            } else if (current != ' ') {
                sign = current;
            }
        }

        while (!stack.isEmpty()) {
            output += stack.pop();
        }

        return output;
    }
}