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

    private void preOrder(TreeNode root, StringBuffer sb) {
        if (root == null) sb.append("null,");
        else {
            sb.append(root.val + ",");
            preOrder(root.left, sb);
            preOrder(root.right, sb);
        }
        
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        preOrder(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(",")) {
            nodes.add(s);
        }
        return helpDeserialize(nodes); 
    }

    private TreeNode helpDeserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) return null;
        
        String first = nodes.removeFirst(); // 移除并返回此列表的第一个元素
        if ("null".equals(first)) {
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.valueOf(first).intValue()); // 或者Integer.parseInt(first)
        
        root.left = helpDeserialize(nodes);
        root.right = helpDeserialize(nodes);
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));