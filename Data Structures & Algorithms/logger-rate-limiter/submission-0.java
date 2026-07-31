class Logger {
    HashMap<String, Integer> map;

    public Logger() {
        this.map = new HashMap<>();    
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!map.containsKey(message)) {
            map.put(message, timestamp);
            return true;
        }

        int prevTimeStamp = map.get(message);
        if (timestamp < prevTimeStamp + 10) {
            return false;
        }
        else {
            map.put(message, timestamp);
            return true;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
