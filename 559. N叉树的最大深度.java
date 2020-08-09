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
    public int maxDepth(Node root) {
        if (root == null) return 0;
        Queue<Node> q = new LinkedList<>();
        int everyLevelSize = 0;
        int level = 0;
        q.offer(root);

        while(!q.isEmpty()) {
            level++;
            everyLevelSize = q.size();
            
            for (int i = 0; i < everyLevelSize; i++) {
                Node cur = q.poll();
            
                for(Node n : cur.children) {
                    q.offer(n);
                }
            }
            
        }
        return level;
    }
}