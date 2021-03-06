/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    private void postorder(Node node, List<Integer> res) {
        if (node == null) return;
        for(Node i : node.children) {
            postorder(i, res);
        }
        res.add(node.val);
    }
}