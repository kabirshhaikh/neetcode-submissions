class Solution {
    public int findLonelyPixel(char[][] picture) {
        int output = 0;

        for (int i = 0; i < picture.length; i++) {
            char[] curr = picture[i];

            for (int j = 0; j < curr.length; j++) {
                if (curr[j] == 'B') {
                    int rowCount = 0;
                    int colCount = 0;

                    int column = j;

                    // first count all B's in row:
                    for (int col = 0; col < curr.length; col++) {
                        if (curr[col] == 'B')
                            rowCount++;
                    }

                    // second count all B's in col:
                    for (int row = 0; row < picture.length; row++) {
                        if (picture[row][column] == 'B')
                            colCount++;
                    }

                    // if counts of row and col == 1 then increment output:
                    if (rowCount == 1 && colCount == 1) {
                        output++;
                    }
                }
            }
        }

        return output;
    }
}
