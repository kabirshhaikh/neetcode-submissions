class Leaderboard {
    HashMap<Integer, Integer> map;

    public Leaderboard() {
        this.map = new HashMap<>();
    }

    public void addScore(int playerId, int score) {
        map.put(playerId, map.getOrDefault(playerId, 0) + score);
    }

    public int top(int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int score : map.values()) {
            pq.offer(score);
        }

        int sum = 0;

        for (int i=0; i<K; i++) {
            sum = sum + pq.poll();
        }

        return sum;
    }

    public void reset(int playerId) {
        map.remove(playerId);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */
