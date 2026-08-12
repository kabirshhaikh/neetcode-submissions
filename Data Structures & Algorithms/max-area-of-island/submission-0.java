class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        //here i record rows and cols count of grid:
        int rows = grid.length; int cols = grid[0].length;

        //so first i define a 2d boolean array called visited which will by default have false as value for all cells:
        boolean[][] visited = new boolean[rows][cols];

        //now i define a maxArea variable which will be comapred against the dfs result we get in the for loop:
        int maxArea = 0;

        //now i run a loop over grid and where ever we find a 1 cell, we dfs on that cell:
        for (int row=0; row<grid.length; row++) {
            for (int col=0; col<grid[row].length; col++) {
                if (grid[row][col] == 1) {
                    int dfsOutput = dfs(grid, row, col, visited);
                    maxArea = Math.max(maxArea, dfsOutput);
                }
            }
        }

        return maxArea;
    }

    //now here i write the recursive dfs method which has return type of int:
    public int dfs (int[][] grid, int row, int col, boolean[][] visited) {
        //first base case (boundary check):
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length) {
            return 0;
        }

        //second base case:
        //if current cell is 0, then return 0
        if (grid[row][col] == 0) {
            return 0;
        }

        //third base case:
        //if current cell is 1 and it is already marked as true then return 0:
        if (grid[row][col] == 1 && visited[row][col] == true) {
            return 0;
        }

        //otherwise we mark the current cell as visited:
        visited[row][col] = true;

        //now we recurse left, right, top and bottom:
        //left:
        int left = dfs(grid, row, col - 1, visited);

        //right:
        int right = dfs(grid, row, col + 1, visited);

        //top:
        int top = dfs(grid, row - 1, col, visited);

        //bottom:
        int bottom = dfs(grid, row + 1, col, visited);

        //in the end i return 1 + left + right + top + bottom to the calling function:
        return 1 + left + right + top + bottom;
    }
}

//so this is a dfs problem:
//this is how the algo will work.
//i will first create a visited boolean array of size grid, meaning all cells will be false.
//then i maintain a counter called maxArea set to 0.
//then i run a for loop on int row < grid.length and inner nested for loop in it where col < grid[row].length.
//inside it i check if grid[row][col] == 1 then run dfs on it.
//then whatever ans i get in here i check it against maxArea and update maxArea
//in the end i return maxArea


//the dfs algo which has return type of int:
//first base case:
//if row < 0 || row >= grid.length || col < 0 || col >= grid[row].length then return 0.

//second base case:
//if grid[row][col] == 0 then return 0;

//if grid[row][col] == 1 && visited[row][col] == true then also return 0.

//otherwise mark visited[row][col] = true.

//check its left, right, up and down.

//gather the info and return 1 + left + right + up + down.