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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int everyLevelSize = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            everyLevelSize = q.size();
            List<Integer> everyLeveList = new ArrayList<>();
            for(int i = 0; i < everyLevelSize; i++) {
                TreeNode cur = q.poll();
                everyLeveList.add(cur.val);

                if(cur.left != null) {
                    q.offer(cur.left);
                }
                if(cur.right != null) {
                    q.offer(cur.right);
                }
            }

            res.add(0, everyLeveList);
        }

        return res;
    }
}