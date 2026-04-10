class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<int[]> stack = new ArrayDeque<>();
        int[] output = new int[temperatures.length];
       
        for (int i=0; i<temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] >stack.peek()[0]) {
                int[] currPop = stack.pop();              
                output[currPop[1]] = i - currPop[1];
            }

            int[] temp = new int[2];
            temp[0] = temperatures[i]; temp[1] = i;
            stack.push(temp);
        }

        return output;
    }
}
