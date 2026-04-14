class TimeMap {
    class Pair {
        String value;
        int timestamp;

        public Pair (String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    HashMap<String, List<Pair>> map;
    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Pair> temp = map.getOrDefault(key, new ArrayList<>());
        temp.add(new Pair(value, timestamp));
        map.put(key, temp);
    }
    
    public String get(String key, int timestamp) {
        List<Pair> temp = map.getOrDefault(key, new ArrayList<>());
        if (temp.size() == 0) {
            return "";
        }

        int left = 0; int right = temp.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Pair pair = temp.get(mid);
            if (pair.timestamp == timestamp) {
                return pair.value;
            }
            else if (pair.timestamp < timestamp) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        if (right < 0) return "";
        return temp.get(right).value;
    }
}
