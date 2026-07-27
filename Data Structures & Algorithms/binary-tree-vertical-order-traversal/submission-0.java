/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        //output list:
        List<List<Integer>> output = new ArrayList<>();

        //base check:
        //return empty arraylist:
        if (root == null) {
            return output;
        }

        //here i define the hashmap to hold column number as KEY and VALUE as the List of Node:
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        //here i define queue to hold object array:
        Queue<Object[]> q = new ArrayDeque<>();
        q.offer(new Object[] {root, 0});

        //now i run the while loop until q is not empty:
        while (!q.isEmpty()) {
            //here i capture current size of q to run loop on that:
            int size = q.size();

            for (int i=0; i<size; i++) {
                Object[] curr = q.poll(); //here i poll the current object array:
                TreeNode node = (TreeNode) curr[0];
                int columnNumber = (int) curr[1];

                //here i first add the current node to the map where
                //KEY is columnNumber and VALUE is list of integers:
                List<Integer> listOfNodes = map.getOrDefault(columnNumber, new ArrayList<>());
                listOfNodes.add(node.val);
                map.put(columnNumber, listOfNodes);

                //if left child is not null:
                //when going left, -1 to whatever columnNumber is:
                if (node.left != null) {
                    //now add the left child in the queue:
                    q.offer(new Object[] {node.left, columnNumber - 1});
                }

                //if right child is not null:
                //when going right, +1 to whatever columnNumber is:
                if (node.right != null) {
                    //now add the right child in the queue:
                    q.offer(new Object[] {node.right, columnNumber + 1});
                }
            }
        }

        //here i get the min and max col number from map:
        int minCol = Collections.min(map.keySet());
        int maxCol = Collections.max(map.keySet());

        //i run a for loop starting from minCol until maxCol:
        //in each iteration i get list for that ith index from map and add it
        //to the output list:
        for (int i=minCol; i<= maxCol; i++) {
            output.add(map.get(i));
        }

        //here i return the final output list:
        return output;
    }
}

// q = {    [3, 0]        }

// while (!q.empty())
// poll current to capture size of q meaning current elements in q:
// run for loop that many times:
// first is 3 for loop runs only once:
// -> extract 3 
// check left and right child of 3 is not null, if not then add them to q 
// based on 3's column number from hashmap:
// left child will be 0 -1 and right will be 0 + 1:

// [3, 0]
// [9 , -1]
// [20, 1]
// [15, 0]
// [7, 2]




