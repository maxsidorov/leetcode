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
    long max; 
    
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        maxPathSumHelper(root);
        return (int)max;
    }
    
    public long maxPathSumHelper(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        long left = maxPathSumHelper(root.left);
        long right = maxPathSumHelper(root.right);
        long result = Math.max(root.val + left, root.val + right);
        result = Math.max(result, root.val);
        max = Math.max(max, result);
        max = Math.max(max, root.val + left + right);
        return result;
    }
}
