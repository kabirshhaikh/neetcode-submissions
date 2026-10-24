class FirstUnique {
    private final Queue<Integer> q;
    private final HashMap<Integer, Integer> map;

    public FirstUnique(int[] nums) {
        this.q = new ArrayDeque<>();
        this.map = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            int curr = nums[i];
            q.offer(curr);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }  
    }
    
    public int showFirstUnique() {
        while (!q.isEmpty()) {
            int number = q.peek();
            if (map.get(number) == 1) {
                return number;
            }
            else {
                q.poll();
            }
        }

        return -1;
    }
    
    public void add(int value) {
        q.offer(value);
        map.put(value, map.getOrDefault(value, 0) + 1);
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
