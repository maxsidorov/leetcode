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
    
    private int curr;
    
    public int kthSmallest(TreeNode root, int k) {
        curr = 1;
        return kthSmallestImpl(root, k);
    }
    
    private Integer kthSmallestImpl(TreeNode root, int k) {
        if (root == null) return null;
        
        Integer result = kthSmallestImpl(root.left, k);
        if (result != null)  return result;
        
        if (k == curr) return root.val;
        curr++;
        
        return kthSmallestImpl(root.right, k);
    }
}
