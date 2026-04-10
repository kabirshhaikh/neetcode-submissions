class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < asteroids.length; i++) {
            int curr = asteroids[i];

            if (curr > 0) {
                stack.push(curr);
            } else {
                boolean destroyed = false;

                while (!stack.isEmpty() && stack.peek() > 0) {
                    if (stack.peek() < Math.abs(curr)) {
                        stack.pop();
                    } 
                    else if (stack.peek() > Math.abs(curr)) {
                        destroyed = true; 
                        break;
                    } 
                    else {
                        stack.pop(); 
                        destroyed = true;
                        break;
                    }
                }

                if (!destroyed) {
                    stack.push(curr);
                }
            }
        }

        int[] output = new int[stack.size()];
        int i = output.length - 1;
        while (!stack.isEmpty()) {
            output[i--] = stack.pop();
        }

        return output;
    }
}