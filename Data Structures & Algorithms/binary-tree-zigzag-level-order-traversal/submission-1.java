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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //if the root is null:
        if (root == null) {
            List<List<Integer>> output = new ArrayList<>();
            return output; 
        }

        //left to right is EVEN AND right to left is ODD:
        int level = 0;

        //here i am gonna define a queue:
        Queue<TreeNode> q = new ArrayDeque<>();

        //i am gonna push the root into q:
        q.offer(root);

        //now I am gonna define the output list:
        List<List<Integer>> output = new ArrayList<>();

        //now I am gonna run a while loop until its not empty:
        while (!q.isEmpty()) {
            int size = q.size(); //capture the size:

            //this list will hold traversal:
            List<Integer> list = new ArrayList<>();

            //run a for loop:
            for (int i=0; i<size; i++) {
                TreeNode poppedNode = q.poll();

                //check if left and right are not null:
                if (poppedNode.left != null) {
                    q.offer(poppedNode.left);
                }

                if (poppedNode.right != null) {
                    q.offer(poppedNode.right);
                }

                //add poppedNode into list:
                list.add(poppedNode.val);
            }

            //after adding popping and adding next level into q, check if level is odd
            //or even:
            if (level % 2 == 0) {
                output.add(list);
            }
            else {
                //add the list in reverse order:
                List<Integer> reverse = new ArrayList<>();
                for (int i=list.size() - 1; i>=0; i--) {
                    reverse.add(list.get(i));
                }

                output.add(reverse);
            }

            //after this increment level:
            level++;
        }

        //return output:
        return output;
    }
}