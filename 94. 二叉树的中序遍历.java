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
    // 递归形式
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrder(root, res);
        return res;
    }

    private void inOrder(TreeNode root, List<Integer> res) {
        if(root == null) return;
        inOrder(root.left, res);
        res.add(root.val);
        inOrder(root.right, res);
    }

}

//----------------中序遍历的迭代形式---------------
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
    // 迭代形式
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> call = new Stack<>();
        if(root != null) {
            call.push(root);
        }

        while(!call.empty()) {
            TreeNode t = call.peek();
            call.pop();

            if(t != null) {
                if(t.right != null) call.push(t.right);
                call.push(t);
                call.push(null);
                if(t.left != null) call.push(t.left);
            } else {
                res.add(call.peek().val);
                call.pop();
            }
        }

        return res;
    }
}