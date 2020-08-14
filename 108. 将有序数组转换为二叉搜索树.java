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