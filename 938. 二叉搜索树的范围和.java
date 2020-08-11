/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//----------------------方法1---------------------------------
class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root==null) return 0;
        int sum = 0;
        List<Integer> res = new ArrayList<>();
        inOrder(root, res);
        for(int i=1;i<res.size();i++){
            if(res.get(i) >= L && res.get(i) <= R){
                sum += res.get(i);
            }
        }
        return sum;
    }

    private void inOrder(TreeNode root, List<Integer> res){
        if(root == null) return;
        inOrder(root.left, res);
        res.add(root.val);
        inOrder(root.right, res);
        
    }
}
//-----------------------方法2----------------------------------
class Solution {
    int sum = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root==null) return 0;
        inOrder(root, L, R);
        return sum;
    }

    private void inOrder(TreeNode root, int L, int R){
        if(root == null) return;
        inOrder(root.left, L, R);
        if (root.val >= L && root.val <= R) sum += root.val;
        inOrder(root.right, L, R);
        
    }
}
//--------------------方法3-----------------------------------
class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        if (root.val < L) {
            return rangeSumBST(root.right, L, R);
        }
        if (root.val > R) {
            return rangeSumBST(root.left, L, R);
        }
        return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }
}


//链接：https://leetcode-cn.com/problems/range-sum-of-bst/solution/hua-jie-suan-fa-938-er-cha-sou-suo-shu-de-fan-wei-/
