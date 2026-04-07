class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        //in this problem i need only maxprofit so no need for min difference and all:
        for (int i=1; i<prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                maxProfit = maxProfit + prices[i] - prices[i-1];
            }
        }

        return maxProfit;
    }
}