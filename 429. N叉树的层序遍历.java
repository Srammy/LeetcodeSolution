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
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        int everyLevelSize = 0;
        q.offer(root);

        while(!q.isEmpty()) {
            everyLevelSize = q.size();
            List<Integer> everyLevelList = new ArrayList<>();
            for (int i = 0; i < everyLevelSize; i++) {
                Node cur = q.poll();
                everyLevelList.add(cur.val);

                for(Node n : cur.children) {
                    q.offer(n);
                }
            }
            res.add(everyLevelList);
        }
        return res;
    }
}