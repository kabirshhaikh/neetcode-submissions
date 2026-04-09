class Solution {
    public boolean isValidSudoku(char[][] board) {
        //here i initialize a 2D hashset:
        HashSet<Character>[][] subBoxSet = new HashSet[3][3];

        //here I am initializing new HashSet at each cell:
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                subBoxSet[i][j] = new HashSet<>();
            }
        }

        //here i loop over the board array, this is outer loop - the row loop:
        for (int r=0; r<board.length; r++) {
            //two hashsets to make detect duplicate digits for rows and cols:
            HashSet<Character> rowsSet = new HashSet<>();
            HashSet<Character> colsSet = new HashSet<>();
            
            //this is inner loop which loops over each element of the current row:
            for (int c=0; c<board[r].length; c++ ) {
                //this gets current row element:
                char rowElement = board[r][c];

                //this gets current col element:
                char colElement = board[c][r];

                //this tells which box the current row and col belong to, by diving 3 it gives that ans:
                int boxRow = r/3;
                int boxCol = c/3;

                //here i check if current row element is a digit or not:
                if (rowElement != '.') {
                   if (rowsSet.contains(rowElement)) {
                    return false;
                   }
                   else {
                    rowsSet.add(rowElement);
                   }
                }

                //here i check if current col element is a digit or not:
                if (colElement != '.') {
                    if (colsSet.contains(colElement)) {
                        return false;
                    } 
                    else {
                     colsSet.add(colElement);  
                    }
                }

                //if row element is not empty then:
                if (rowElement != '.') {
                    //if the 2d hashset contains this rowElement at specified place then return false:
                    if (subBoxSet[boxRow][boxCol].contains(rowElement)) {
                        return false;
                    }
                    //otherwise add the rowElement to the specified place in 2D hashset:
                    else {
                        subBoxSet[boxRow][boxCol].add(rowElement);
                    }
                }
            }
        }


        return true;
    }
}
