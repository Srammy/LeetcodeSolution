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
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if(pre == null || post == null) return null;
        Map<Integer, Integer> rootIndexInPostorderMap = new HashMap<>();
        for(int i = 0; i < post.length; i++) {
            rootIndexInPostorderMap.put(post[i], i);
        }
        return rebuildTree(pre, rootIndexInPostorderMap, 0, 0, post.length - 1);
    }

    private TreeNode rebuildTree(int[] pre, Map<Integer, Integer> rootIndexInPostorderMap, int preIndex, int postLeftIndex, int postRightIndex) {
        if (postLeftIndex == postRightIndex) return new TreeNode(pre[preIndex]);
        if (postLeftIndex > postRightIndex) return null;
        TreeNode root = new TreeNode(pre[preIndex]);
        int rootIndexInPostorder = rootIndexInPostorderMap.get(pre[preIndex]);
        int rootNextNodeIndexInPostorder = rootIndexInPostorderMap.get(pre[preIndex + 1]);
        
        root.left = rebuildTree(pre, rootIndexInPostorderMap, preIndex + 1, postLeftIndex, rootNextNodeIndexInPostorder);
        root.right = rebuildTree(pre, rootIndexInPostorderMap, preIndex + rootNextNodeIndexInPostorder - postLeftIndex + 2, rootNextNodeIndexInPostorder + 1, rootIndexInPostorder - 1);
        return root;
    }
}