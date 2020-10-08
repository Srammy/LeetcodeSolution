/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return (Math.abs(treeHeight(root.left)-treeHeight(root.right)) <= 1) && isBalanced(root.left) && isBalanced(root.right);
    }

    private int treeHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return 1 + Math.max(treeHeight(node.left), treeHeight(node.right));
    }
}