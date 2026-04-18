class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        int left = 0; 

        for (int right=0; right<nums.length; right++) {
            //first check if number on right > number of back of dq, if yes then keep removing it:
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[right]) {
                dq.removeLast();
            }

            //then add current nums[right] to back of the dq:
            dq.addLast(right);

            //clean the front remove if outside the window:
            if (dq.peekFirst() < left) {
                dq.removeFirst();
            }

            //then check if the size of window == k then record element sitting at front:
            if (right - left + 1 == k) {
                list.add(nums[dq.peekFirst()]);
                left++;
            }
        }

        int[] output = new int[list.size()];

        for (int i=0; i<list.size(); i++) {
            output[i] = list.get(i);
        }

        return output;
    }
}
