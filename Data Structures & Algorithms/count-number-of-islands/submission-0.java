class Solution {
    public int numIslands(char[][] grid) {
        int islandCount = 0;
        for (int row=0; row<grid.length; row++) {
            for (int col=0; col<grid[row].length; col++) {
                //if the current cell is '1' then i do dfs and explore all the adjacent
                //cells to mark them as #
                if (grid[row][col] == '1') {
                    dfs(grid, row, col);

                    //after exploring i increment the count:
                    islandCount++;
                }
            }
        }

        //in the end i return the count of number of islands we encountered:
        return islandCount;
    }
    
    public void dfs (char[][] grid, int row, int col) {
        //base case 1: check bounds for row and col:
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length) {
            return;
        }

        //base case 2: check if current char not '1' then return:
        if (grid[row][col] != '1') {
            return;
        }

        //at this point current element is 1 and i convert that to '#' to display it
        //as marked:
        grid[row][col] = '#';

        //now i recurse left, right, top and bottom:
        //left:
        dfs(grid, row, col - 1);

        //right:
        dfs(grid, row, col + 1);

        //top:
        dfs(grid, row - 1, col);

        //bottom:
        dfs(grid, row + 1, col);
    }
}


// char[][] grid = {
//     {'1','1','0'},
//     {'1','1','0'},
//     {'0','0','1'}
// };

// count = 2;

// for loop iteration 0th row:
// (0,0) -> 1
// call stack 1:dfs(grid, 0, 0)
// -> at this point 
//{
//     {'-1','1','0'},
//     {'1','1','0'},
//     {'0','0','1'}
// }

// increment count from 0 to 1 after getting returned from call stack 1:

// dfs left right top bottom, after making (0,0) as -1 we go right because top and left is out of bounds:

// dfs(grid, 0, 1)
// dfs(grid, 1, 0) -> this became -1 at call stack 4.
// gets return from call stack 2, call stack 1 returns to for loop.

// call stack 2:
//     {'-1','-1','0'},
//     {'1','1','0'},
//     {'0','0','1'}
// }
// now we go only down nothing else is there
// dfs(grid, 1,1)
// got a return from call stack 3, call stack 2 returns to call stack 1:

// call stack 3: 
//     {'-1','-1','0'},
//     {'1','-1','0'},
//     {'0','0','1'}
// }
// only left is 1
// dfs(grid, 1, 0)
// gets a return from call stack 4, now call stack 3 returns to call stack 2

// call stack 4:
//     {'-1','-1','0'},
//     {'-1','-1','0'},
//     {'0','0','1'}
// }
// at this point when i do dfs on left rigth top bottom it returns beause element is not 1, so from here we return back to call stack 3.

//main method:
// so outer for loop runs until grid.length
// inner for loop runs until last element of current row
// we then check if grid[row][col] == 1
// then we do dfs
// and increment the island count

// [
// dfs (recursion) return type void method:
// -> base case to check boundary:
// if row is less than 0 || row is greater than grid.length
// OR
// col is less than 0 || col is greater than grid[row].length
// in that case return:

//base case 2: if current element is not 1 then return, either is marked -1 or is 0 meaning water:
//if grid[row][col] != 1:
//return

// -> then we check if grid[row][col] == 1
// make that -1 for marking it done

// ->then we dfs up down left right
// ]