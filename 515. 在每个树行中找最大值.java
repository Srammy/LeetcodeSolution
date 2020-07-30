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
    public List<Integer> largestValues(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }

        int max = Integer.MIN_VALUE;
        int everyLevelSize = 0;
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            everyLevelSize = q.size(); // 每一层节点的个数

            // 对每一层进行操作
            for(int i = 0; i < everyLevelSize; i++) {
                TreeNode cur = q.poll();
                if(cur.val > max) {
                    max = cur.val;
                }

                if(cur.left != null) {
                    q.offer(cur.left);
                }
                if(cur.right != null) {
                    q.offer(cur.right);
                }
            }
            res.add(max);
            max = Integer.MIN_VALUE;
        }
        return res;
    }
}