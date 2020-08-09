/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //-------------------方法1-----------------------
class Solution {
    public void construct_paths(TreeNode root, String path, LinkedList<String> paths) {
        if (root == null) return; 
        path += Integer.toString(root.val);
        if (root.left == null && root.right == null) {  // 当前节点是叶子节点
            paths.add(path);  // 把路径加入到答案中
        } else {
            path += "->";  // 当前节点不是叶子节点，继续递归遍历
            construct_paths(root.left, path, paths);
            construct_paths(root.right, path, paths);
        }
        
    }

    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<String> paths = new LinkedList();
        construct_paths(root, "", paths);
        return paths;
    }

}
//----------------------方法2：其实和方法1是一样的。----------------------
class Solution {
     public void construct_paths(TreeNode root, String path, LinkedList<String> paths) {
        path += Integer.toString(root.val);
        if (root.left == null && root.right == null) {  // 当前节点是叶子节点
            paths.add(path);  // 把路径加入到答案中
        } 

        path += "->";  // 当前节点不是叶子节点，继续递归遍历
        if (root.left != null) construct_paths(root.left, path, paths);
        if (root.right != null) construct_paths(root.right, path, paths);
        
    }

    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return new LinkedList<String>();
        LinkedList<String> paths = new LinkedList();
        construct_paths(root, "", paths);
        return paths;
    }

}