/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//-----------------------------my method------------------------------
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return sortedArrayToBST(nums, 0, nums.length-1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) return null;
        if (left == right) return new TreeNode(nums[left]);
        int mid = left + (right - left)/2;
        if ((right - left) % 2 == 1) mid++;
        // System.out.println("mid:" + mid);
        TreeNode root = new TreeNode(nums[mid]);
        root.right = sortedArrayToBST(nums, mid + 1, right);
        root.left = sortedArrayToBST(nums, left, mid - 1);
        return root;
    }
}

//---------------简单的实现--------------
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        } 
        // 以升序数组的中间元素作为根节点 root。
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        // 递归的构建 root 的左子树与右子树。
        root.left = dfs(nums, left, mid - 1);
        root.right = dfs(nums, mid + 1, right); 
        return root;
    }
}