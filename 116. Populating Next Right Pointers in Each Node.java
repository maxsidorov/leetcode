/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root != null) {
            // print(root);
            LinkedList<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
            queue.add(root);
            int amountInLevel = 1;
            while (!queue.isEmpty()) {
                TreeLinkNode node = queue.removeFirst();
                amountInLevel--;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (amountInLevel == 0) {
                    amountInLevel = queue.size();
                } else {
                    node.next = queue.get(0);
                }
            }
        }
        
    }
    
    public void connectImpl(TreeLinkNode left, TreeLinkNode right) {
        if (left != null) {
            left.next = right;
            connectImpl(left.left, left.right);
            connectImpl(left.right, right.left);
            connectImpl(right.left, right.right);
        }
        
    }
}
