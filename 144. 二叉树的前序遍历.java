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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }

    private void preOrder(TreeNode root, List<Integer> res) {
        if(root == null) return;
        res.add(root.val);
        if(root.left != null) {
            preOrder(root.left, res);
        }
        if(root.right != null) {
            preOrder(root.right, res);
        }
    }
}
//-----------------在上面基础上的优化----------------
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }

    private void preOrder(TreeNode root, List<Integer> res) {
        if(root == null) return;
        res.add(root.val);
        preOrder(root.left, res); // 这里不再判断 root.left != null，是因为上面的if(root == null) return;已经做了
        preOrder(root.right, res);

    }
}

//------------前序遍历的迭代实现--------------
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
    // 迭代实现
    public List<Integer> preorderTraversal(TreeNode root) {
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
                if(t.left != null) call.push(t.left);
                call.push(t);
                call.push(null);
            } else {
                res.add(call.peek().val);
                call.pop();
            }
        }
        return res;
    }
}