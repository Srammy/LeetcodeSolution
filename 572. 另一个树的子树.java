/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 /**
*一个树是另一个树的子树 则
*要么这两个树相等
*要么这个树是左树的子树
*要么这个树是右树的子树
 */
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) return true;   // t 为 null 一定都是 true
        if (s == null) return false;  // 这里 t 一定不为 null, 只要 s 为 null，肯定是 false
		// 一个树是另一个树的子树 则要么这个树是左树的子树,要么这个树是右树的子树，要么这两个树相等
        return isSubtree(s.left, t) || isSubtree(s.right, t) || isSameTree(s,t);
    }


    // 判断两棵树是否相同
	// 两树相同=>根节点一样+两树左子树一样+两树右子树一样
    public boolean isSameTree(TreeNode s, TreeNode t){
        if (s == null && t == null) return true; // 必须放在前面
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}