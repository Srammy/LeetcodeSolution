/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//--------------------------方法1------------------------------
class Solution {
    
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        List<Integer> res = new ArrayList<>();
        inOrder(root, res);
        for(int i=1;i<res.size();i++){
            if(res.get(i)<=res.get(i-1)){
                return false;
            }
        }
        return true;
    }

    private void inOrder(TreeNode root, List<Integer> res){
        if(root == null) return;
        inOrder(root.left, res);
        res.add(root.val);
        inOrder(root.right, res);
        
    }
}
//-------------------方法2----------------------------------
class Solution {
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 访问左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // 访问右子树
        return isValidBST(root.right);
    }
}

//方法2链接：https://leetcode-cn.com/problems/validate-binary-search-tree/solution/zhong-xu-bian-li-qing-song-na-xia-bi-xu-miao-dong-/

//----------------方法3:-----------------------------
class Solution {
    TreeNode pre = null;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        
		boolean left = isValidBST(root.left);
		
		if (pre != null && pre.val >= root.val) {
			return false;
		}
		pre = root;
		
		boolean right = isValidBST(root.right);
		
		return left && right;
		
    }
}
