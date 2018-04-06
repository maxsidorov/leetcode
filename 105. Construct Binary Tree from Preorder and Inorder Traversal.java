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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inorderValueToIndexMap = new HashMap();
        for (int i = 0; i < inorder.length; i++) {
            inorderValueToIndexMap.put(inorder[i], i);
        }
        return buildTreeImpl(inorderValueToIndexMap, preorder, inorder, 0, 0, inorder.length);
    }
    
    public TreeNode buildTreeImpl(HashMap<Integer, Integer> inorderValueToIndexMap, int[] preorder, int[] inorder, int preorderLeft, int inorderLeft, int len) {
        System.out.println("preorderLeft, inorderLeft, len = " + preorderLeft + " " + inorderLeft + " " +  len);
        if (len <= 0) {
            return null;
        }
        
        TreeNode node = new TreeNode(preorder[preorderLeft]);
        int inorderIndex = inorderValueToIndexMap.get(node.val);
        int leftLen = inorderIndex - inorderLeft;
        node.left = buildTreeImpl(inorderValueToIndexMap, preorder, inorder, preorderLeft + 1, inorderLeft, leftLen);
        node.right = buildTreeImpl(inorderValueToIndexMap, preorder, inorder, preorderLeft + 1 + leftLen, inorderLeft + 1 + leftLen, inorderLeft + len - inorderIndex - 1);
        return node;
    }
}
