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
class Solution {
    public int pathSum(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        int rootPathNum = countPath(root, sum);
        int leftPathNum = pathSum(root.left, sum);
        int rightPathNum = pathSum(root.right, sum);
        return rootPathNum + leftPathNum + rightPathNum;

    }
    public int countPath(TreeNode root,int sum){
        if(root == null){
            return 0;
        }

        int result = 0;
        if (sum == root.val) {
            result = 1;
        }
        
        return result + countPath(root.left, sum - root.val) + countPath(root.right, sum - root.val);
    }
}