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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        LinkedList<TreeNode> queue = new LinkedList();
        boolean isOdd = true;
        queue.add(root);
        while (queue.size() > 0 ) {
            LinkedList<Integer> level = new LinkedList();
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.removeFirst();
                if (isOdd) {
                    level.add(node.val);
                } else {
                    level.addFirst(node.val);
                }
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            isOdd = !isOdd;
            result.add(level);
        }
        return result;
    }
}
