class MovingAverage {
    int windowSize;
    ArrayDeque<Integer> q;
    double runningSum;

    public MovingAverage(int size) {
        this.windowSize = size;
        this.q =  new ArrayDeque<>();
        this.runningSum = 0.0;
    }
    
    public double next(int val) {
        if (q.size() == windowSize) {
            int numberGettingRemoved = q.poll();
            runningSum = runningSum - numberGettingRemoved;
            q.offer(val);
            runningSum = runningSum + val;
            return runningSum / q.size();
        }


        //if size of q is less than equal to windowSize then add the number to runningSum and to q:
        q.offer(val);
        runningSum = runningSum + val;
        return runningSum / q.size(); 
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
