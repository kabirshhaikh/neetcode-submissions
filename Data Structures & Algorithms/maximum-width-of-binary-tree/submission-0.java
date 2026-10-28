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
    class Pair {
        TreeNode root;
        long index;

        public Pair (TreeNode root, long index) {
            this.root = root;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(root, 0));

        long maxWidth = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            long firstIndex = q.peek().index;
            long lastIndex = 0;

            for (int i=0; i<size; i++) {
                Pair popped = q.poll();
                TreeNode poppedNode = popped.root;
                long index = popped.index - firstIndex;

                if (i == size - 1) {
                    lastIndex = index;
                }
                
                if (popped.root.left != null) {
                    q.offer(new Pair(popped.root.left, 2 * index + 1));
                }

                if (popped.root.right != null) {
                    q.offer(new Pair(popped.root.right, 2 * index + 2));
                }
            }

            maxWidth = Math.max(maxWidth, lastIndex + 1);
        }

        return (int) maxWidth;
    }
}
