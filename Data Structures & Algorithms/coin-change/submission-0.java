class Solution {
    public int coinChange(int[] coins, int amount) {
        //here i define 2d array:
        int[][] dp = new int[coins.length][amount + 1];

        //fill everything with -1:
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int result = dfs(0, coins, amount, dp);

        if (result == Integer.MAX_VALUE) {
            return -1;
        }
        else {
            return result;
        }
    }

    public int dfs (int index, int[] coins, int amount, int[][] dp) {
        //base case 1: if target is 0 then return 0:
        if (amount == 0) {
            return 0;
        }

        //base case 2: if target is out of bounds then return Integer.max value:
        if (index == coins.length) {
            return Integer.MAX_VALUE;
        }

        //base case 3: if dp has ans then return it:
        if (dp[index][amount] != -1) {
            return dp[index][amount];
        }

        //define take as max value:
        int take = Integer.MAX_VALUE;

        //perform dfs for this only when current num is <= target amount:
        if (coins[index] <= amount) {
            int result = dfs(index, coins, amount - coins[index], dp);
            if (result != Integer.MAX_VALUE) {
                //add 1 because we selected 1 one regardless of which coin we used:
                take = 1 + result;
            }
        }

        //here dont subtract coins[index] from amount:
        int skip = dfs(index + 1, coins, amount, dp);

        //choose min value:
        int minimumValue = Math.min(take, skip);

        //set cache:
        dp[index][amount] = minimumValue;

        //return whatever is min of both:
        return minimumValue;
    }
}

// dfs:
// base case: if index out of bounds and target > 0 then return Integer.MAX_VALUE
// base case: if target == 0 then return 0;
// int take = 1 + dfs(same index, coins, target - coins[same index]);
// int skip = dfs(index + 1, coins, target - coints[index]);
// return Math.min(take, skip)