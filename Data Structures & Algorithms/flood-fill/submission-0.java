class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        //here i capture the start color of the cell:
        int startColor = image[sr][sc];

        //if the start color of the cell == color then no need to dfs:
        //else recurse and change the colors of the cell:
        if (startColor != color) {
            dfs(startColor, image, sr, sc, color);
        }

        //in the end i return the image itself:
        return image;
    }

    public void dfs (int startColor, int[][] image, int sr, int sc, int color) {
        //base case for out of bounds:
        //if row is greater than all count of rows in the image grid OR
        //row is less than 0 OR
        //column is greater than or equal to current rows length OR
        //if column is less than 0
        if (sr >= image.length || sr < 0 || sc >= image[sr].length || sc < 0) {
            return;
        }

        //second base case: when current cell is not of startColor then return:
        if (image[sr][sc] != startColor) {
            return;
        }

        //if we have passed both the base cases then change current cells color:
        image[sr][sc] = color;

        //now traverse the neighbours in 4 directions:
        //up:
        dfs(startColor, image, sr - 1, sc, color);

        //down:
        dfs(startColor, image, sr + 1, sc, color);

        //left:
        dfs(startColor, image, sr, sc - 1, color);

        //right:
        dfs(startColor, image, sr, sc + 1, color);
    }
}

// [
//     [1,1,1],
//     [1,1,0],
//     [1,0,1],
// ]

//pseudo code:
// i will capture startColor as startColor = image[sr][sc] which is one.
// then pass it to dfs recursion function.
// dfs(startColor, image, and color)

// now in dfs i will check
// base case:
// if image[sr][sc] != startColor || image[sr][sc] == color then return;//meaning either different color or already coloured
// if image[sr][sc] == startColor then change it to new color,
// then grab the neighbours and make sure they are not out of bounds.
// then dfs on them.



//if i start from (1,1) -> 1
// i change that to 2.
// its neighbours are (0,1), (1,0), (2,1), (1,2)
// (1,2) is not same color so skip it.

// now recursion starts.
// before recursion i will check if (0,1) not null or is not out of bounds.
// if no then i will check if it has same color, not sure how to check?
// will i pass parent color?
// then if same as parent then change (0,1) becomes 2

// now (0,1) has neighbours (0,0), (0,2) and (1,1)
// (1,1) we started from there and has old color not sure how to check that but we wont process this.

// then (0,0), bounds check, it passes then we change its color to 2.

// now (0,0) has neightbours (0,1) and (1,0)
// we came from (0,1) so now need to change anything there.


// i mean like this way we can do flood fill