/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        while (root != null) {
            stack.add(root);
            root = root.left;
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.removeLast();
            result.add(node.val);
            if (node.right != null) {
                node = node.right;  
                while (node != null) {
                    stack.add(node);
                    node = node.left;
                }
            }
        }
        return result;
        
    }
}
