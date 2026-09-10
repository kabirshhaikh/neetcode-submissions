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
    public List<List<Integer>> findLeaves(TreeNode root) {
        //so here i define hashmap:
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        dfs(root, map);

        List<List<Integer>> output = new ArrayList<>();

        int maxHeight = Collections.max(map.keySet());

        for (int i=0; i<= maxHeight; i++) {
            output.add(map.get(i));
        }

        return output;
    }

    public int dfs (TreeNode root, HashMap<Integer, List<Integer>> map) {
        //base case: if root is null return -1:
        if (root == null) {
            return -1;
        }

        int leftTree = dfs(root.left, map);
        int rightTree = dfs(root.right, map);

        int height = 1 + Math.max(leftTree, rightTree);

        List<Integer> list = map.getOrDefault(height, new ArrayList<>());

        list.add(root.val);

        map.put(height, list);

        return height;
    }
}



// so i will maintain a hashmap where key is integer height of a node at current level and value is list integers which will be nodes at same heigh