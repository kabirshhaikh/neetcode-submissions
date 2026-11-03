class Solution {
    public int rob(int[] nums) {
        //so here i am gonna define index variable starting at 0:
        int index = 0;

        //here i define a 1d array for memoization:
        int[] dp = new int[nums.length];

        //now i will enter all values with Integer.MIN_VALUE:
        for (int i=0; i<dp.length; i++) {
            dp[i] = Integer.MIN_VALUE;
        }

        //now i will call my dfs recursion function:
        int dfsResult = dfs(nums, index, dp);

        //in the end i return the dfs result:
        return dfsResult;
    }

    //here i define my helper recursion function of return type int:
    public int dfs (int[] nums, int index, int[] dp) {
        //first base case: if index is out of bounds then return 0:
        if (index >= nums.length) {
            return 0;
        }

        //second base case: if there exists a max value in dp for this index then return it:
        if (dp[index] != Integer.MIN_VALUE) {
            return dp[index];
        }

        //otherwise explore both possibilities meaning rob current and skip next house
        //or skip current and rob next house:
        int robCurrent = dfs(nums, index + 2, dp);
        int skipCurrent = dfs(nums, index + 1, dp);

        int maxValue = Math.max(robCurrent + nums[index], skipCurrent);

        //set maxValue for this index in dp:
        dp[index] = maxValue;

        return maxValue;
    }
}


//boolean visited = [false, false, false, false];
//nums =            [1,     1,     3,     3];