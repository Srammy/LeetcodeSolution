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
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;
        List<String> paths = new ArrayList<>();
        findPath(root, "", paths);
        for(String str : paths) {
            sum += Integer.parseInt(str);
        }
        return sum;
    }

    private void findPath(TreeNode node, String path, List<String> paths) {
        path += node.val;
        if (node.left == null && node.right == null) {
            paths.add(path);
        }

        if (node.left != null) findPath(node.left, path, paths);
        if (node.right != null) findPath(node.right, path, paths);

    }
}