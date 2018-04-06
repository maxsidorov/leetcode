/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        serializeImpl(root, list);
        String result = list.stream()
            .map(val -> val !=null ? val.toString() : "null")
            .collect(Collectors.joining(","));
        System.out.println(result);
        return result;
    }
    
    public void serializeImpl(TreeNode root, List<Integer> list) {
        if (root == null) {
            list.add(null);
        } else {
            list.add(root.val);
            serializeImpl(root.left, list);
            serializeImpl(root.right, list);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<Integer> list = Arrays.stream(data.split(","))
            .map(s -> !"null".equals(s) ? Integer.parseInt(s) : null)
            .collect(Collectors.toList());
        System.out.println(list.toString());
        return deserializeImpl(list.iterator());
    }
    
    public TreeNode deserializeImpl(Iterator<Integer> iterator) {
        Integer val = iterator.next();
        if (val == null) {
            return null;
        } else {
            TreeNode node = new TreeNode(val);
            node.left = deserializeImpl(iterator);
            node.right = deserializeImpl(iterator);
            return node;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
