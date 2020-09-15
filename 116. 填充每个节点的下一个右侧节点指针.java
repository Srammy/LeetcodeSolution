//---------------------方法1：BFS-----------------------
// 对每一层进行操作
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int everyLevelSize = 0;

        while (!q.isEmpty()) {
            everyLevelSize = q.size();
            for (int i = 0; i < everyLevelSize; i++) {
                Node cur = q.poll();
                if (i + 1 == everyLevelSize) {
                    cur.next = null;
                } else {
                    cur.next = q.peek();
                }

                if (cur.left != null) {
                    q.offer(cur.left);
                }

                if (cur.right != null) {
                    q.offer(cur.right);
                }

                
            }
        }

        return root;

    }
}
//-----------------------------方法2：递归------------------------------------
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        connectTwoNode(root.left, root.right);
        return root;
    }

    // 连接两个相邻的节点
    private void connectTwoNode(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return; 
        }

        // 连接传入的节点
        node1.next = node2;

        // 分别对传入的两个节点进行操作，连接其左右节点
        connectTwoNode(node1.left, node1.right);
        connectTwoNode(node2.left, node2.right);

        // 连接跨越父节点的两个子节点
        connectTwoNode(node1.right, node2.left);
    }
}