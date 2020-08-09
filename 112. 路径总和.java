/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//------------------方法1：在树里面找所有条和为sum的路径。有的话，返回true，没有的话，返回false--------------------
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        boolean hasPath = false;

        List<List<Integer>> paths = new ArrayList<List<Integer>>();
        findPath(root, sum, new ArrayList(), paths);

        if(paths.size() != 0) hasPath = true;
        else hasPath = false;

        return hasPath;
    }
    
    // 在树里面找一条和为sum的路径
    private void findPath(TreeNode node, int sum, ArrayList<Integer> path, List<List<Integer>> paths) {
        path.add(node.val);
        if (node.val == sum && node.left == null && node.right == null) {
            paths.add((ArrayList<Integer>)path.clone());
        }
        if (node.left != null) findPath(node.left, sum - node.val, path, paths);
        if (node.right != null) findPath(node.right, sum - node.val, path, paths);
        path.remove(path.size() - 1);
    }
}
//------------------------------方法2：直接递归----------------------------------
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
