/**
 *in-place 的意思可能更多说的是直接在原来的节点上改变指向，空间复杂度并没有要求
 */
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
 *先序遍历，按遍历顺序将节点添加到nodeList中
 * 对nodeList操作，原地构成一个链表
 * 空间复杂度O(N)
 */
class Solution {
    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }
        List<TreeNode> nodeList = new LinkedList<>();
        //先序遍历，按遍历顺序将节点添加到nodeList中
        preOrder(root, nodeList);
        // 对nodeList操作，原地构成一个链表
        for(int i = 0; i < nodeList.size() - 1; i++) {
            nodeList.get(i).left = null;
            nodeList.get(i).right = nodeList.get(i + 1);
        }
    }

    // 先序遍历
    private void preOrder(TreeNode root, List<TreeNode> nodeList) {
        if(root == null) return;
        nodeList.add(root);
        preOrder(root.left, nodeList);
        preOrder(root.right, nodeList);
    }
}
