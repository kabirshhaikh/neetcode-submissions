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
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return -1;
        }

        Queue<TreeNode> pq = new ArrayDeque<>();
        pq.offer(root);

        int leftMost = root.val;

        while (!pq.isEmpty()) {
            int size = pq.size();

            for (int i=0; i<size; i++) {
                TreeNode popped = pq.poll();
                if (i == 0) {
                    leftMost = popped.val;
                }

                if (popped.left != null) {
                    pq.offer(popped.left);
                }

                if (popped.right != null) {
                    pq.offer(popped.right);
                }
            }
        }

        return leftMost;
    }
}
