/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
byte,short,char----->int------>long------>float----->double
不同数据类型运行时，都转换为较大的数据类型（向上转型），最后结果也是较大的数据类型。
当然也可以强制类型转换为需要的类型（强制向下转型）。
 */
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        int everyLevelSize = 0;
        double sum = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            everyLevelSize = q.size();
            for(int i = 0; i < everyLevelSize; i++) {
                TreeNode cur = q.poll();
                sum = sum + cur.val; // double + int = double

                if(cur.left != null) {
                    q.offer(cur.left);
                }
                if(cur.right != null) {
                    q.offer(cur.right);
                }
            }
            res.add(sum/everyLevelSize); // double/int = double
            sum = 0;
        }
        return res;
    }
}