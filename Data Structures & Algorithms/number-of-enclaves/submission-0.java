class Solution {
    //here i define a class level boolean variable:
    boolean touches = false;

    public int numEnclaves(int[][] grid) {
        //here i track rows and cols:
        int rows = grid.length; int cols = grid[0].length;

        //so first i define a boolean[][] array to track visited 1 cells.
        boolean[][] visited = new boolean[rows][cols];

        //here i define the output variable:
        int count = 0;

        //now i loop over grid:
        for (int row=0; row<grid.length; row++) {
            for (int col=0; col<grid[row].length; col++) {
                //if current cell is 1 and not visited then perform dfs:
                if (grid[row][col] == 1 && !visited[row][col]) {
                    //in here i set the class level variable touches as false:
                    touches = false;

                    int countFromDfs = dfs(row, col, visited, grid);

                    //now i check if touches is false then i increment count with
                    //countFromDfs number:
                    if (!touches) {
                        count += countFromDfs;
                    }
                }
            }
        }

        //in the end i return count:
        return count;
    }

    //now here i write my dfs function which has return type of int:
    public int dfs (int row, int col, boolean[][] visited, int[][] grid) {
        //first base case: boundary check:
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length) {
            //then in this case set touches as true and return 0:
            touches = true;
            return 0;
        }

        //second base case: if current cell is 0 return 0:
        if (grid[row][col] == 0) {
            return 0;
        }

        //third base case: if current cell is 1 and already visited then return 0:
        if (grid[row][col] == 1 && visited[row][col]) {
            return 0;
        }

        //otherwise mark current cell as visited:
        visited[row][col] = true;

        //now perform recursion in 4 directions:
        int up = dfs(row - 1, col, visited, grid);
        int down = dfs(row + 1, col, visited, grid);
        int left = dfs(row, col - 1, visited, grid);
        int right = dfs(row, col + 1, visited, grid);

        //in the end return 1 + up + down + left + right to calling function in stack:
        return 1 + up + down + left + right;
    }
}

// 0 -> water
// 1 -> land

// I can move from 1 (land) in 4 directions up (-1, 0), down (+1, 0), 
// left (0, -1) and right (0, +1).
 
// similarly by performing above steps i can also walk off the grid meaning go out of bounds.

// I have to return number of 1's (land cells) for which i cannot walk of the boundary/go out of bounds.

// So i have to start from 1 (land cell), traverse and make sure that traversal ends inside the grid it it goes out of bounds then thats what i am not looking for.

// cell with co-ordinate: (2, 2) qualifies for the answer.

// so the problem requires dfs:
// i maintain a boolean[][] visited array to mark all 1's visited with true.
// at class level i will define a boolean variable touches.

// i then define a variable count for output:

// i loop over grid and whenever i encounter a 1 which is not visited i perform dfs on it:
// dfs gives me a count, i then check if touches is false then i increment count by the count dfs method gave.

// after for loop ends i return count variable.

// logic for dfs helper function starts here:
// the dfs helper function of return type int:
// base case:
// if out of boundary: return 0 and set touches as true.

// second base case: if current cell is 0 return 0.

// mark current positon as visited in boolean array that I will get as an input in dfs.

// then perform dfs in 4 directions:
// int up = dfs();
// int down = dfs();
// int left = dfs();
// int right = dfs();
// then i return 1 + up + down + left + right.

