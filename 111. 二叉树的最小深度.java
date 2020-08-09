/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//--------------------------方法1：BFS---------------------------
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int level = 0;
        int everyLevelSize = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            level++;
            everyLevelSize = q.size();
            for (int i = 0; i < everyLevelSize; i++) {
                TreeNode cur = q.poll();
                
                if(cur.left == null && cur.right == null) { // 如果是叶子节点说明已经找到了最短路径
                    return level;
                }
                
                if (cur.left != null) {
                    q.offer(cur.left);
                }
     
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
        }
        return level;
    }
}
//---------------------方法2：DFS 找出所有的路径，求所有路径长度的最小值----------------------