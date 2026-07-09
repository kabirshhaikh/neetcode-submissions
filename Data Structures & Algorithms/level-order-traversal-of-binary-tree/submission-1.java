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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>(); //this will hold output:

        //if the root itself is null, return output list which is empty:
        if (root == null) {
            return output;
        }

        Queue<TreeNode> q = new ArrayDeque<>();

        //here i add the root the very first val:
        q.add(root);

        //then i run this operation until q is not empty:
        while (!q.isEmpty()) {
            //this gives us how many nodes we need to process at each level:
            int currentLevelSize = q.size();

            //this is temp list which will be added into output:
            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < currentLevelSize; i++) {
                //pop current top node:
                TreeNode popped = q.poll();

                //add its neighbours to the q:
                if (popped.left != null) {
                    q.offer(popped.left);
                }

                if (popped.right != null) {
                    q.offer(popped.right);
                }

                //after adding the neighbours to q, add the popped node to temp list:
                temp.add(popped.val);
            }

            output.add(temp);
        }

        return output;
    }
}
