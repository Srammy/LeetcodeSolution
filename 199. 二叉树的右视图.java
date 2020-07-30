/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//------------------------方法1：BFS--------------
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int everyLevelSize = q.size(); // 每一层节点的个数
            // 对每一层进行操作
            for(int i = 0; i < everyLevelSize; i++) {
                TreeNode cur = q.poll();
                if(i == everyLevelSize-1) {   // 只需要每一层最右边（for最后遍历到的）的节点
                    res.add(cur.val);
                }

                if(cur.left != null) {
                    q.offer(cur.left);
                }
                if(cur.right != null) {
                    q.offer(cur.right);
                }
            }
        }
        return res;
    }
}
//-----------------------方法2：DFS-------------------------
class Solution {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, 0, res); // 从根节点开始，当前深度为0
        return res;
    }

    /*
    @description: 按照根节点->右子树->左子树的方式遍历，这样可以是得每层最先遍历到的是最右边的节点
    @param: node 当前遍历到的节点
    @param：depth 当前节点的深度
    @param；res 保存每层最右边的节点
    */
    public void dfs(TreeNode node, int depth, List<Integer> res) {
        if(node == null) return;

        if(depth == res.size()) { // 如果当前节点所在深度还没有出现在res里(即depth == res.szie)，说明在该深度下当前节点是第一个被访问的节点，因此将当前节点加入res中。
            res.add(node.val);
        }
        System.out.println("当前depth:" + depth + "------->" + "当前res:" + res +"当前res.size:" + res.size());
        dfs(node.right, depth + 1, res);
        dfs(node.left, depth + 1, res);
    }
}