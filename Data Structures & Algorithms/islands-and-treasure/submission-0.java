class Solution {
    public void islandsAndTreasure(int[][] grid) {
        //so in here first i loop over the grid and add all the cell positions where its 0 meaning treasure chest into a queue:
        //here i define a queue:
        Queue<int[]> q = new ArrayDeque<>();

        //now i loop over the grid and add the positions of cell which has 0:
        for (int row=0; row<grid.length; row++) {
            for (int col=0; col<grid[row].length; col++) {
                if (grid[row][col] == 0) {
                    q.offer(new int[] {row, col});
                }
            }
        }

        //now i run a while loop on queue until its not empty:
        while (!q.isEmpty()) {
            //i poll the top most int object:
            int[] popped = q.poll();
            int row = popped[0];
            int col = popped[1];

            //now i check up down left and right:
            //up:
            int upRow = row - 1;
            int upCol = col;

            //first boundary check:
            if (upRow >= 0 && upRow < grid.length && upCol >= 0 && upCol < grid[upRow].length) {
                //now i check if the current cell is INF:
                if (grid[upRow][upCol] == Integer.MAX_VALUE) {
                    //then i first update the distance of current cell:
                    grid[upRow][upCol] = grid[row][col] + 1;

                    //after that i push the current cell into queue:
                    q.offer(new int[] {upRow, upCol});
                }
            }

            //down:
            int downRow = row + 1;
            int downCol = col;

            //first boundary check:
            if (downRow >= 0 && downRow < grid.length && downCol >= 0 && downCol < grid[downRow].length) {
                //now i check if the current cell is INF:
                if (grid[downRow][downCol] == Integer.MAX_VALUE) {
                    //then i first update the distance of current cell:
                    grid[downRow][downCol] = grid[row][col] + 1;

                    //after that i push the current cell into queue:
                    q.offer(new int[] {downRow, downCol});
                }
            }


            //left:
            int leftRow = row;
            int leftCol = col - 1;

            //first boundary check:
            if (leftRow >= 0 && leftRow < grid.length && leftCol >= 0 && leftCol < grid[leftRow].length) {
                //now i check if the current cell is INF:
                if (grid[leftRow][leftCol] == Integer.MAX_VALUE) {
                    //then i first update the distance of current cell:
                    grid[leftRow][leftCol] = grid[row][col] + 1;

                    //after that i push the current cell into queue:
                    q.offer(new int[] {leftRow, leftCol});
                }
            }

            //right:
            int rightRow = row;
            int rightCol = col + 1;

            //first boundary check:
            if (rightRow >= 0 && rightRow < grid.length && rightCol >= 0 && rightCol < grid[rightRow].length) {
                //now i check if the current cell is INF:
                if (grid[rightRow][rightCol] == Integer.MAX_VALUE) {
                    //then i first update the distance of current cell:
                    grid[rightRow][rightCol] = grid[row][col] + 1;

                    //after that i push the current cell into queue:
                    q.offer(new int[] {rightRow, rightCol});
                }
            }
        }

        //and thats it in the end i dont have to return anything, after the while loop the grid will have updated distances.
    }
}

// 1 cannot be traversed.
// 0 is treasure chest.
// any integer is a land cell that can be traversed.

// so here i need to start dfs from each land cell.
// then when i hit a 0 i need to return 0 and calling cells will become 1 + ans from returned function.

//   [2147483647,-1,0,2147483647],
//   [2147483647,2147483647,2147483647,-1],
//   [2147483647,-1,2147483647,-1],
//   [0,-1,2147483647,2147483647]

//   so here i will write a for loop, detect cells with value 0 and push them into a queue.

//   then i run a while loop until queue is not empty.
//   i pop the cell check its up down left and right value.
//   if its INF then i update that cells value in place with distance.
//   if its 0 then i simply skip that and -1.

//   in the end i dont reutrn anything because method signature is void. so it will have in place modified grid.