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
        List<List<Integer>> output = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();

        if (root == null) {
            return output;
        }

        q.offer(root);

        while (!q.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int size = q.size(); // took the snapshot of the size:

            // now process the size count:
            for (int i = 0; i < size; i++) {
                // first pop:
                TreeNode popped = q.pop();
                temp.add(popped.val);

                // after popping add the children to queue:
                // if left child is not null add it:
                if (popped.left != null) {
                    q.offer(popped.left);
                }

                // if right child is not null then add it:
                if (popped.right != null) {
                    q.offer(popped.right);
                }
            }

            output.add(temp);
        }

        return output;
    }
}
