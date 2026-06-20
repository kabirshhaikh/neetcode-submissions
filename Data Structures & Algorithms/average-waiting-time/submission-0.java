class Solution {
    public double averageWaitingTime(int[][] customers) {
        long currentTime = 0;
        long totalTime = 0;

        for (int i=0; i<customers.length; i++) {
            int[] customer = customers[i];
            int arrivalTime = customer[0];
            int time = customer[1];

            currentTime = Math.max(currentTime, arrivalTime) + time;
            totalTime += currentTime - arrivalTime;
        }

        return (double) totalTime/customers.length;
    }
}

