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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return hasPathSumImpl(root, sum, 0);
    }
    
    public boolean hasPathSumImpl(TreeNode root, int sum, int parentSum) {
        if (root.left == null && root.right == null) return sum == parentSum + root.val;
        if (root.left != null && hasPathSumImpl(root.left, sum, parentSum + root.val)) return true;
        if (root.right != null && hasPathSumImpl(root.right, sum, parentSum + root.val)) return true;
        return false;
    }
}
