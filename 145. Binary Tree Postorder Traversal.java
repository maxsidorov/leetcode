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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode prev = null;
        
        TreeNode next = root;
        
        while (next != null) {
            stack.push(next);
            if (stack.peek().left != null) {
                next = stack.peek().left;
            } else {
                next = stack.peek().right;
            }
        }

        while (!stack.isEmpty()) {
            prev = stack.pop();
            result.add(prev.val);
            if (!stack.isEmpty() && stack.peek().right != null && stack.peek().right != prev) {
                next = stack.peek().right;
                while (next != null) {
                    stack.push(next);
                    if (stack.peek().left != null) {
                        next = stack.peek().left;
                    } else {
                        next = stack.peek().right;
                    }
                }
            }
        }
        
        return result;
    }
}
