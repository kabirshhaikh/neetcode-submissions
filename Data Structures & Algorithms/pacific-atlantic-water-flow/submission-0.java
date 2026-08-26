class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        //here i need two boolean arrays pacific and atlantic which initially is false:

        //here i capture the heights of rows and col:
        int rows = heights.length; int cols = heights[0].length;

        //now i define two boolean arrays:
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        //now i run for loop only on top row and left most col:
        for (int col=0; col<heights[0].length; col++) {
            if (!pacific[0][col]) {
                dfs(0, col, pacific, heights, heights[0][col]);
            }
        }

        //now i run a loop only on the left most col:
        for (int row=0; row<heights.length; row++) {
             if (!pacific[row][0]) {
                dfs(row, 0, pacific, heights, heights[row][0]);
            }
        }

        //now i run a loop only for last col:
        for (int row=0; row<heights.length; row++) {
            if (!atlantic[row][heights[0].length - 1]) {
                dfs(row, heights[0].length - 1, atlantic, heights, heights[row][heights[0].length - 1]);
            }
        }

        //now i run a loop only for the last row:
        for (int col=0; col<heights[heights.length - 1].length; col++) {
            int lastRow = heights.length - 1;
            if (!atlantic[lastRow][col]) {
                dfs(lastRow, col, atlantic, heights, heights[lastRow][col]);
            }
        }

        //now i define output list:
        List<List<Integer>> output = new ArrayList<>();

        //now after performing recusrion on top left right and down rows of heights, i run a for loop on pacific and for each cell i check if thats true in pacific and if its true for same co-ordinate in atlantic as well then i push that position in output list:
        for (int row=0; row<pacific.length; row++) {
            for (int col=0; col<pacific[0].length; col++) {
                boolean isPacific = pacific[row][col];
                boolean isAtlantic = atlantic[row][col];

                if (isPacific && isAtlantic) {
                    List<Integer> cellCoordinates = new ArrayList<>();
                    cellCoordinates.add(row);
                    cellCoordinates.add(col);

                    output.add(cellCoordinates);
                }
            }
        }

        //and in the end i return output list:
        return output;
    }

    //here i write my helper recursion dfs function of return type void:
    public void dfs (int row, int col, boolean[][] ocean, int[][] heights, int parent) {
        //first base case: if the row or col is out of bounds then return:
        if (row < 0 || row >= heights.length || col < 0 || col >= heights[0].length) {
            return;
        }

        //second base case: if current node is less than parent then return:
        if (heights[row][col] < parent) {
            return;
        }

        //third base case: if current cell already marked then return:
        if (ocean[row][col]) {
            return;
        }

        //otherwise i mark the current ocean as marked/visited:
        ocean[row][col] = true;

        //now i perform recursion up down left and right:
        //up:
        dfs(row - 1, col, ocean, heights, heights[row][col]);

        //down:
        dfs(row + 1, col, ocean, heights, heights[row][col]);

        //left:
        dfs(row, col - 1, ocean, heights, heights[row][col]);

        //right:
        dfs(row, col + 1, ocean, heights, heights[row][col]);
    }
}


// rc represents height above sea level for that row col.
// so i need two boolean 2d arrays one for pacific and one for atlantic of row length =  heights.length and col length = heights[0].length.

// then i do two seprate dfs search.
// i first loop over top row and left most col only.
// start my dfs and check if my neighbour is of same height or greater than i mark that as visited.

// then i do the same for atlantic.
// i start from last col and last row and perform same dfs.
// perform dfs is atlanctic row col is false.

// then i loop over pacific boolean and check if current row col in pacific and current row col in atlantic true then add that position in output array.

// dfs recursion function of type void:
// first break case: boundary check hits then return.

// second base case:
// if parent meaning the function from which we came down in stack that number is less than current number then return. dont mark.

// otherwise mark this position as true in atlantic/pacific boolean.

// then reurse up down left and right.