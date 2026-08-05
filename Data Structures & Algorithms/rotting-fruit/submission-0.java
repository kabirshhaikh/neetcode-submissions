class Solution {
    public int orangesRotting(int[][] grid) {
        //here i define the queue:
        Queue<int[]> q = new ArrayDeque<>();

        //counter for fresh oranges and min:
        int freshOranges = 0; int min = 0;

        //here i run a for loop to count fresh oranges and add position of rotten oranges in the queue:
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[] {i, j});
                }

                if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        //now i run a while loop until q is not empty:
        while (!q.isEmpty()) {
            int size = q.size(); //here i capture the size of q to run for loop on it

            boolean isFresh = false;

            for (int i=0; i<size; i++) {
                int[] popped = q.poll(); //here i pop current int[]
                int row = popped[0];
                int col = popped[1];
                
                //after popping i check up,down,left and right.
                //up 
                int upRow = row - 1; int upCol = col;
                //here i check bounds for upRow and upCol:
                if (upRow >= 0 && upRow < grid.length && upCol >= 0 && upCol < grid[upRow].length) {
                    //if upper element is 1 then i add that position in q and make it rot:
                    //then i decrement fresh count and mark isFresh = true:
                    if (grid[upRow][upCol] == 1) {
                        q.offer(new int[] {upRow, upCol});

                        grid[upRow][upCol] = 2;

                        freshOranges--;

                        isFresh = true;
                    }
                }

                //down 
                int downRow = row + 1; int downCol = col;
                //here i check bounds for downRow and downCol:
                if (downRow >= 0 && downRow < grid.length && downCol >= 0 && downCol < grid[downRow].length) {
                    //if upper element is 1 then i add that position in q and make it rot:
                    //then i decrement fresh count and mark isFresh = true:
                    if (grid[downRow][downCol] == 1) {
                        q.offer(new int[] {downRow, downCol});

                        grid[downRow][downCol] = 2;

                        freshOranges--;

                        isFresh = true;
                    }
                }

                //left 
                int leftRow = row; int leftCol = col - 1;
                //here i check bounds for leftRow and leftCol:
                if (leftRow >= 0 && leftRow < grid.length && leftCol >= 0 && leftCol < grid[leftRow].length) {
                    //if upper element is 1 then i add that position in q and make it rot:
                    //then i decrement fresh count and mark isFresh = true:
                    if (grid[leftRow][leftCol] == 1) {
                        q.offer(new int[] {leftRow, leftCol});

                        grid[leftRow][leftCol] = 2;

                        freshOranges--;

                        isFresh = true;
                    }
                }

                 //right 
                int rightRow = row; int rightCol = col + 1;
                //here i check bounds for rightRow and rightCol:
                if (rightRow >= 0 && rightRow < grid.length && rightCol >= 0 && rightCol < grid[rightRow].length) {
                    //if upper element is 1 then i add that position in q and make it rot:
                    //then i decrement fresh count and mark isFresh = true:
                    if (grid[rightRow][rightCol] == 1) {
                        q.offer(new int[] {rightRow, rightCol});

                        grid[rightRow][rightCol] = 2;

                        freshOranges--;

                        isFresh = true;
                    }
                }
            }

            //if even a single fresh orange was detected then i increment min counter:
            if (isFresh) {
                min++;
            }
        }

        //in the end if freshOranges count equals to 0 then return min count else -1
        return freshOranges == 0 ? min : -1;
    }
}

//so i run an initial for loop to count number of fresh oranges.
//in that loop i detect rotten ones and add their positions in a queue.


//then i run a while loop on queue until its empty.
//each step i capture its size and run a for loop on it.
//in the for loop i pop the element.
//check its top down left right elements to see if there is any fresh 1 while
//being in bound.
//if yes then i make then rotten, add their position in queue and decrease count of fresh oranges.
//even if one fresh orange is detected i maintain a boolean variable, after for loop i will check if its true then i increment min counter.

//in the if fresh count == 0 then reutrn min else return -1;
