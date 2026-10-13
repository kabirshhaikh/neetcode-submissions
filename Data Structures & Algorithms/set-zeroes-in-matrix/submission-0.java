class Solution {
    public void setZeroes(int[][] matrix) {
        // note positions of all zeros:
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 0) {
                    visited[row][col] = true;
                }
            }
        }

        // after noting all positions with zero, loop on it to make its row and col as 0:
        for (int i = 0; i < visited.length; i++) {
            for (int j=0; j<visited[i].length; j++) {
                if (visited[i][j]) {
                    int row = i; int col = j;

                    //first make cols as 0:
                    for (int k=0; k<matrix.length; k++) {
                        matrix[k][col] = 0;
                    }

                    //now make rows as 0:
                    for (int l=0; l<matrix[row].length; l++) {
                        matrix[row][l] = 0;
                    }
                }
            }
        }
    }
}
