class Solution {
    public boolean exist(char[][] board, String word) {
        //here i record length of rows and cols:
        int rows = board.length; int cols = board[0].length;

        //here i define a boolean type 2d array to hold visited cells during backtracking, initially all defined as false:
        boolean[][] visited = new boolean[rows][cols];

        //now i run a nested for loop for each cell:
        for (int row=0; row<board.length; row++) {
            for (int col=0; col<board[row].length; col++) {
                int index = 0;
                if (dfs(board, word, row, col, index, visited)) {
                    return true;
                }
            }
        }

        //if the nested loop didnt return true then here i return false:
        return false;
    }

    //this is my helper recursion method:
    public boolean dfs (char[][] board, String word, int row, int col, int index, boolean[][] visited) {
        //first base case: if index == word.length():
        if (index == word.length()) {
            return true; //found the word in the board
        }

        //second base case: boundary check:
        if (row < 0 || row >= board.length || col < 0 || col >= board[row].length) {
            return false;
        }

        //third base case: if visited[row][col] is true, cant reuse same cell in the same path:
        if (visited[row][col] == true) {
            return false;
        }

        //fourth base case:
        if (board[row][col] != word.charAt(index)) {
            return false;
        }

        //then i mark current cell as visited:
        visited[row][col] = true;

        //otherwise i recurse up down left and right:
        //up:
        boolean up = dfs(board, word, row - 1, col, index + 1, visited);

        //down:
        boolean down = dfs(board, word, row + 1, col, index + 1, visited);

        //left:
        boolean left = dfs(board, word, row, col - 1, index + 1, visited);

        //right:
        boolean right = dfs(board, word, row, col + 1, index + 1, visited);

        //if either is true then return true immediately:
        if (up || down || left || right) {
            return true;
        }

        //otherwise i unmark the current cell as false meaning not visited after checking neighbours:
        visited[row][col] = false;

        //then i return false to calling function:
        return false;
    }
}


//so this is a backtracking problem.
//i have to use depth first search here do go in depth and check for each path.
//so i will create a boolean[][] visited array of length board.length and cols = board[0].length.
//then i will write nested for loop:
//for each board[row][col] I will start a dfs and pass in board, word, index = 0, and visited array, row number and col number.
//if the dfs function returns true i return true immediately.
//otherwise after for loop i return false.

//now in the dfs method which will have boolean type as return.
//i will have four base cases:
//first base case will be boundary check:
//if row < 0 || row >= board.length || col < 0 || col >= board[row].length then return false.
//second base case:
//if visited[row][col] == true return false.
//third base case:
//if index == word.length() return true meaning we got the matching word in board.
//fourth base case if word.charAt(index) != board[row][col]
//then return false.
//i mark visited[row][col] = true.

//then i recurse up down left and right:

//after recursing back i check if either call returned true i immediately return true.

//if neither returned true i unmark current visited[row][col] = false.
//and then i return false to the calling function.
