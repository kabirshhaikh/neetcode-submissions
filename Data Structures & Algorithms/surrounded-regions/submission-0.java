class Solution {
    public void solve(char[][] board) {
         //pass one:
        //i write 4 for loops, i check the 0th row all cols:
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == 'O') {
                dfs(board, 0, col);
            }
        }

        //then i write another loop, which will check all the cols from last row:
        for (int col = 0; col < board[board.length - 1].length; col++) {
            if (board[board.length - 1][col] == 'O') {
                dfs(board, board.length - 1, col);
            }
        }

        //then i write a loop to check 0th col (left most) of all rows:
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == 'O') {
                dfs(board, row, 0);
            }
        }

        //then i write final for loop to check all last cols from all the rows:
        for (int row = 0; row < board.length; row++) {
            if (board[row][board[row].length - 1] == 'O') {
                dfs(board, row, board[row].length - 1);
            }
        }

        //now i do pass two:
        //in here i check if any element is 'O' make it 'X' and if any element is '#'
        //then make it 'O':
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                }

                if (board[row][col] == '#') {
                    board[row][col] = 'O';
                }
            }
        }
    }

    public static void dfs(char[][] board, int row, int col) {
        //first base case, boundary check:
        if (row < 0 || row >= board.length || col < 0 || col >= board[row].length) {
            return; //meaning index is out of bounds
        }

        //second base case, if current element is not 'O' then return:
        if (board[row][col] != 'O') {
            return;
        }

        //other wise i mark them as '#'
        board[row][col] = '#';

        //then i do recursion up, down, left and right:
        //up:
        dfs(board, row - 1, col);

        //down:
        dfs(board, row + 1, col);

        //left:
        dfs(board, row, col - 1);

        //right:
        dfs(board, row, col + 1);
    }
}




//so in solve method:
//PASS one:
//i write four for loops, one to check 0th row all cols:
//one for last row all cols
//one for all rows 0th col
//and last one all rows and last col only
//in all the four for loop is check if current element is 'O' then dfs from there

//PASS two:
//i run for loop if any 'O' is identified meaning after first pass it wont be sharing edges with an element on boundary so i convert that one to X
//if a cell is '#' then i convert them back to 'O'

//the dfs recursion method:
//base case i check if the row < 0 || row>=board.length || col < 0 || col >= board[row].length then return;
//second base case:
//if board[row][col] != 'O' the return;
//then i convert that to '#'
//then i recurse up down left right

