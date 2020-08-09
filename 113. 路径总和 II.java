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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> paths = new ArrayList<>();
        findPath(root, sum, new ArrayList<Integer>(), paths);
        return paths;
    }
    private void findPath(TreeNode node, int value, ArrayList<Integer> path, List<List<Integer>> paths) {
        path.add(node.val);
        if (node.val == value && node.left == null && node.right == null) {
            paths.add((ArrayList<Integer>)path.clone());
        }
        if (node.left != null) findPath(node.left, value - node.val, path, paths);
        if (node.right != null) findPath(node.right, value - node.val, path, paths);
        path.remove(path.size() - 1);
    }
}