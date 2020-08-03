//----------递归----------------
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postOrder(root, res);
        return res;
    }

    private void postOrder(TreeNode root, List<Integer> res) {
        if(root == null) return;
        postOrder(root.left, res);
        postOrder(root.right, res);
        res.add(root.val);
    }
}
//---------------------迭代版本-------------------------
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
    //迭代
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> call = new Stack<>();
        if(root != null) {
            call.push(root);
        }

        while(!call.empty()) {
            TreeNode t = call.peek();
            call.pop();

            if(t != null) {
                call.push(t);
                call.push(null);
                if(t.right != null) call.push(t.right);
                if(t.left != null) call.push(t.left);
            } else {
                res.add(call.peek().val);
                call.pop();
            }
        }

        return res;
    }
}