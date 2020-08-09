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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder == null || inorder == null) return null;
        Map<Integer, Integer> rootIndexOfInorderMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            rootIndexOfInorderMap.put(inorder[i], i);
        }
        return rebuildTree(postorder, rootIndexOfInorderMap, postorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode rebuildTree(int[] postorder, Map<Integer, Integer> rootIndexOfInorderMap, int postIndex, int inLeftIndex, int inRightIndex) {
        if (inLeftIndex > inRightIndex) return null;
        TreeNode root = new TreeNode(postorder[postIndex]);
        int rootIndexOfInorder = rootIndexOfInorderMap.get(postorder[postIndex]);
        root.right = rebuildTree(postorder, rootIndexOfInorderMap, postIndex - 1, rootIndexOfInorder + 1, inRightIndex);
        root.left = rebuildTree(postorder, rootIndexOfInorderMap, postIndex - (inRightIndex - rootIndexOfInorder) - 1, inLeftIndex, rootIndexOfInorder - 1);
        return root;
    }

}