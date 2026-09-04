class Solution {
    public int countServers(int[][] grid) {
        //first i define two arrays which will hold count for the ith row and col:
        int[] rows = new int[grid.length];
        int[] cols = new int[grid[0].length];

        //now i loop over grid to count ones at each row and col:
        for (int row=0; row<grid.length; row++) {
            for (int col=0; col<grid[row].length; col++) {
                if (grid[row][col] == 1) {
                    rows[row]++;
                    cols[col]++;
                }
            }
        }

        //now i define the output variable:
        int counter = 0;

        //now i loop over grid again and for each position i check in rows and cols if eithers value is > 1 then i increment counter += with that value:
        for (int row=0; row<grid.length; row++) {
            for (int col=0; col<grid[row].length; col++) {
                if (grid[row][col] == 1 && (rows[row] > 1 || cols[col] > 1)) {
                    counter++;
                }
            }
        }

        return counter;
    }
}

// so this problem requires two passes.
// pass one i define two arrays of size grid.length for rows and grid[0].length for columns.
// then i loop over grid, for each row i count how many 1's are there.
// and then set the count for that rows array with count of 1.
// same i do for columns.

// then in pass two:
// in the second pass i loop over grid and for each position i check in rows and col to see if its val > 1, if yes then i increment my output counter.

// [1,1,0,0],
// [0,0,1,0],
// [0,0,1,0],
// [0,0,0,1]