/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
*/

class Solution {
    public Node connect(Node root) {
        //if root is null then i return null;
        if (root == null) {
            return null;
        }

        //here i use the implementation of the Arraydeque:
        Queue<Node> q = new ArrayDeque<>();

        //since at this point root is not null, so i add it in q:
        q.offer(root);

        //now i run a while loop until q is not empty:
        while (!q.isEmpty()) {
            int currSize = q.size(); //here i take snapshot of curent level:
            for (int i = 0; i < currSize; i++) {
                //at each iteration i pop a node from q:
                Node popped = q.poll();

                //first i check if left and right children are not null, then add to q:
                if (popped.left != null)
                    q.offer(popped.left);
                if (popped.right != null)
                    q.offer(popped.right);

                //now i check if ith element is last element left then point its next to null else
                //to the next sitting node in q by peekin it:
                if (i == currSize - 1) {
                    popped.next = null;
                } else {
                    popped.next = q.peek();
                }
            }
        }

        //in the end i return the root which has next pointing to right:
        return root;
    }
}