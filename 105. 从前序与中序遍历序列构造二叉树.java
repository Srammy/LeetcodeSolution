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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null) return null;
        Map<Integer, Integer> rootIndexOfInorderMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            rootIndexOfInorderMap.put(inorder[i], i);
        }
        return rebuildTree(preorder, rootIndexOfInorderMap, 0, 0, preorder.length - 1);

    }

    private TreeNode rebuildTree(int[] preorder, Map<Integer, Integer> rootIndexOfInorderMap, int preIndex, int inLeftIndex, int inRightIndex) {
        if (inLeftIndex > inRightIndex) return null;

        TreeNode root = new TreeNode(preorder[preIndex]);
        int rootIndexOfInorder = rootIndexOfInorderMap.get(preorder[preIndex]);
        root.left = rebuildTree(preorder, rootIndexOfInorderMap, preIndex + 1, inLeftIndex, rootIndexOfInorder - 1);
        root.right = rebuildTree(preorder, rootIndexOfInorderMap, preIndex + rootIndexOfInorder - inLeftIndex + 1, rootIndexOfInorder + 1, inRightIndex);

        return root;
    }
}