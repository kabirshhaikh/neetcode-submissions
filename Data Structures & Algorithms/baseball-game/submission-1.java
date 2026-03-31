class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<operations.length; i++) {
            if (!operations[i].equals("D") && !operations[i].equals("+") && !operations[i].equals("C")) {
                stack.push(Integer.parseInt(operations[i]));
            }
            else if (operations[i].equals("+") && stack.size() >= 2) {
               int last = stack.pop();
               int secondLast = stack.peek();

               int sum = last + secondLast;
               stack.push(last);
               stack.push(sum);
            }

            else if (operations[i].equals("D") && stack.size() >= 1) {
                int previous = stack.peek();
                stack.push(previous * 2);
            }

           else if (operations[i].equals("C") && stack.size() >= 1) {
                stack.pop();
            }
        }

        //sum of stack:
        int output = 0;

        for (int i=0; i<stack.size(); i++) {
            output = output + stack.get(i);
        }

        return output;
    }
}