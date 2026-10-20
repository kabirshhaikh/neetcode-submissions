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
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        TreeNode dummy = new TreeNode(-1);
        boolean nullFound = false;

        while (!q.isEmpty()) {
            int size = q.size(); //capture current level size:
        
            for (int i=0; i<size; i++) {
                TreeNode popped = q.poll();

                //if null found:
                if (popped == dummy) {
                    nullFound = true;
                    continue;
                }

                //if null already found:
                if (nullFound) {
                    return false;
                }

                //after popping add its children to q, if null then add -1
                if (popped.left == null) {
                    q.offer(dummy);
                }
                else {
                    q.offer(popped.left);
                }

                if (popped.right == null) {
                    q.offer(dummy);
                }
                else {
                    q.offer(popped.right);
                }
            }
        }

        return true;
    }
}

//so here i am gonna use queue which wil hold int values.