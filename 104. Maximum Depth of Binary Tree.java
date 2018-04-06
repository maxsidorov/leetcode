class Solution1 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}

class Solution2 {
    int answer = 0;
    
    public int maxDepth(TreeNode root) {
        maxDepthImpl(root, 1);
        return answer;
    }
    public void maxDepthImpl(TreeNode root, int depth) {
        if (root != null) {
            if (root.left == null && root.right == null && answer < depth) {
                answer = depth;
            }
            maxDepthImpl(root.left, depth + 1);
            maxDepthImpl(root.right, depth + 1);
        }
        
    }
}
