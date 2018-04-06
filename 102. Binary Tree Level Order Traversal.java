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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList();
            queue.add(root);
            while (!queue.isEmpty()) {
                Queue<TreeNode> nextQueue = new LinkedList();
                List<Integer> list = new ArrayList<Integer>();
                while (!queue.isEmpty()) {
                    TreeNode node = queue.poll();
                    list.add(node.val);
                    if (node.left != null) {
                        nextQueue.add(node.left);
                    }
                    if (node.right != null) {
                        nextQueue.add(node.right);
                    }
                }
                result.add(list);
                queue = nextQueue;
            }
        }
        
        return result;
    }
}
