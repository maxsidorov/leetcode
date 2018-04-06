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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeImpl(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    public TreeNode buildTreeImpl(int[] inorder, int inorderLeft, int inorderRight, int[] postorder, int postorderLeft, int postorderRight) {
        if (postorderLeft > postorderRight) {
            return null;
        }
        TreeNode node = new TreeNode(postorder[postorderRight]);
        int rootIndex = inorderLeft;
        while (inorder[rootIndex] != node.val) {
            rootIndex++;
        }
        node.left = buildTreeImpl(inorder, inorderLeft, rootIndex - 1, postorder, postorderLeft, postorderLeft + rootIndex - 1 - inorderLeft);
        node.right = buildTreeImpl(inorder, rootIndex + 1, inorderRight, postorder, postorderRight - 1 - (inorderRight - (rootIndex + 1)), postorderRight - 1);
        return node;
    }
}
