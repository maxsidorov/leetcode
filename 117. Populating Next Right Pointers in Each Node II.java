/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    
        
    public void connect(TreeLinkNode root) {
        TreeLinkNode first = root;
        while (first != null) {
            TreeLinkNode currParent = first;
            first = null;
            TreeLinkNode curr = null;
            while (currParent != null) {
                if (currParent.left != null) {
                    if (curr == null) {
                        first = currParent.left;
                    } else {
                        curr.next = currParent.left;
                    }
                    curr = currParent.left;
                }
                if (currParent.right != null) {
                    if (curr == null) {
                        first = currParent.right;
                    } else {
                        curr.next = currParent.right;
                    }
                    curr = currParent.right;
                }
                currParent = currParent.next;
            }
        }
        
    }
    
    public void print(TreeLinkNode root) {
        if (root != null) {
            System.out.println("Val = " + root.val + ", left = " + root.left + ", right = " + root.right);
            print(root.left);
            print(root.right);
        }
        
    }
     

}
