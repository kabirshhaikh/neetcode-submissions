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
    public List<Integer> rightSideView(TreeNode root) {
        //the output list, at this point its empty:
        List<Integer> output = new ArrayList<>();

        //if root itself is null then return empty list:
        if (root == null) {
            return output;
        }

        //here i define queue:
        Queue<TreeNode> q = new ArrayDeque<>();

        //since the root is not null at this point, i add it to queue:
        q.offer(root);

        //i run the while loop until q is not empty:
        while (!q.isEmpty()) {
            //here i take the current snapshot of queue:
            int currSize = q.size();

            //this temp list will hold popped node values:
            List<Integer> temp = new ArrayList<>();

            //here i loop over until less than currSize:
            //poll each node:
            //add left and right if not null:
            //then add the popped node's value to temo list:
            for (int i=0; i<currSize; i++) {
                TreeNode popped = q.poll();
                if (popped.left != null) {
                    q.offer(popped.left);
                }

                if (popped.right != null) {
                    q.offer(popped.right);
                }

                //here i add the popped node's value into temp list:
                temp.add(popped.val);
            }

            //at each level the last element in temp is going
            //to be right side node
            output.add(temp.get(temp.size() -1));
        }

        return output;
    }
}
