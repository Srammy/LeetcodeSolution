/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//--------------------------方法1：BFS----------------------
class Solution {
    public int maxDepth(TreeNode root) {
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
//--------------------方法2：递归------------------------
/*
左子树和右子树的最大深度 l 和 r，那么该二叉树的最大深度即为max(l,r)+1，
而左子树和右子树的最大深度又可以以同样的方式进行计算。
在计算当前二叉树的最大深度时，可以先递归计算出其左子树和右子树的最大深度，然后在计算出当前二叉树的最大深度。
递归在访问到空节点时退出。
*/
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}