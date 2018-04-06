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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root != null) {
            LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
            stack.add(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.removeLast();
                result.add(node.val);
                if (node.right != null) {
                    stack.add(node.right);
                }
                if (node.left != null) {
                    stack.add(node.left);
                }
            }
        }
        return result;
    }
    
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     List<Integer> result = new ArrayList<Integer>();
    //     preorderTraversalImpl(root, result);
    //     return result;
    // }
    
    public void preorderTraversalImpl(TreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            preorderTraversalImpl(root.left, list);
            preorderTraversalImpl(root.right, list);
        }
    }
}
