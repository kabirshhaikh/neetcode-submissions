class Solution {
    public int minPathSum(int[][] grid) {
        //so here i grab the last valid row and col index:
        //i will pass this to my dfs recursion function for base case:
        int endRow = grid.length - 1;
        int endCol = grid[endRow].length - 1;

        //here i am going to create a 2d int array to store current cells
        //calculated result:
        int[][] dp = new int[grid.length][grid[0].length];

        //now i will loop over dp array and fill it with Integer.MAX_Value for each cell:
        for (int row=0; row<dp.length; row++) {
            for (int col=0; col<dp[row].length; col++) {
                dp[row][col] = Integer.MAX_VALUE;
            }
        }

        //so here i start my dfs from 0,0 position:
        int dfsResult = dfs(0,0, grid, endRow, endCol, dp);

        return dfsResult;
    }

    public int dfs (int row, int col, int[][] grid, int endRow, int endCol, int[][] dp) {
        //base case 1: if out of boundary then return Integer max val:
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length) {
            return Integer.MAX_VALUE;
        }

        //base case 2: if result for current cell is already stored in dp then return that:
        if (dp[row][col] != Integer.MAX_VALUE) {
            return dp[row][col];
        }

        //base case 3: if i am at endRow and endCol then just return whatever 
        //current cells value is:
        if (row == endRow && col == endCol) {
            //set value in dp:
            dp[row][col] = grid[row][col];
            return grid[row][col];
        }

        //now perform recursion on right and down direction:
        int rightResult = dfs(row, col + 1, grid, endRow, endCol, dp);
        int downResult = dfs(row + 1, col, grid, endRow, endCol, dp);

        //now i will check
        //if rightResult = Max val && downResult is valid then return downResult + current cell val:
        if (rightResult == Integer.MAX_VALUE && downResult != Integer.MAX_VALUE) {
            int result = grid[row][col] + downResult;
            dp[row][col] = result;
            return result;
        }
        //if downResult = maxVal && rightResult is valid then return rightResult + current cell val
        if (downResult == Integer.MAX_VALUE && rightResult != Integer.MAX_VALUE) {
            int result = grid[row][col] + rightResult;
            dp[row][col] = result;
            return result;
        }

        //if both the directions are valid then store the min of those result after adding current cells value to each result:
        int minimumPathSum = Math.min(downResult + grid[row][col], rightResult + grid[row][col]);

        //now set dp arrays current position with minimumPathSum:
        dp[row][col] = minimumPathSum;

        //now return minimumPath sum to calling stack:
        return minimumPathSum;
    }
}