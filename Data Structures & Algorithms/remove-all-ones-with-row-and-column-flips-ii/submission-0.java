class Solution {
    //using this at class level so all the methods can call it:
    HashMap<String, Integer> memo = new HashMap<>();

    public int removeOnes(int[][] grid) {
       return dfs(grid);
    }

    //here i write helper funtion dfs:
    public int dfs (int[][] grid) {
        //here i am gonna use memoization:
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                sb.append(grid[i][j]);
            }
        }

        String key = sb.toString();

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int minOperations = Integer.MAX_VALUE;
        boolean oneFound = false;

        for (int row=0; row<grid.length; row++) {
            for (int col=0; col<grid[row].length; col++) {
                if (grid[row][col] == 1) {
                    oneFound = true;

                    //make copy of grid:
                    int[][] copy = new int[grid.length][];

                    for (int k=0; k<grid.length; k++) {
                        copy[k] = grid[k].clone();
                    }

                    //now set entire row as 0:
                    for (int i=0; i<grid[row].length; i++) {
                        copy[row][i] = 0;
                    }

                    //now set entire col as 0:
                    for (int j=0; j<grid.length; j++) {
                        copy[j][col] = 0;
                    }

                    int operations = 1 + dfs(copy);

                    minOperations = Math.min(minOperations, operations);
                }
            }
        }

        //base case:
        if (!oneFound) {
            memo.put(key, 0);
            return 0;
        }

        //store result in memoization:
        memo.put(key, minOperations);

        //return minOperations:
        return minOperations;
    }
}
