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
 二叉树的层序遍历和图的广度优先搜索（BFS）有些类似
 广度优先搜索（BFS）输出的是一个一维数组
 层序遍历要求输出的是一个二维数组（如本题的要求）
 最好把BFS、层序遍历记为模板
*/
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<List<Integer>>();
        }
        //List<List<Integer>> res = new List<>(); // 这种写法是错误的，List是接口，不能new
        //List<List<Integer>> res = new ArrayList<ArrayList<Integer>>() // //这种写法是错误的,因为泛型类型不一致
        List<List<Integer>> res = new ArrayList<List<Integer>>(); // 这种写法是正确的 存放层序遍历的结果
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int levelSize = q.size(); // 当前层的元素的个数
            List<Integer> everyLevelList = new ArrayList<>(); // 存放每一层的元素。每次while循环，就新建一个ArrayList。
            // 一次性处理本层所有元素
            for(int i = 0; i < levelSize; i++) {
                TreeNode cur = q.poll();
                everyLevelList.add(cur.val);
                // 向队列添加下一层的元素
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if(cur.right != null) {
                    q.offer(cur.right);
                }
            }
            res.add(everyLevelList);
        }
        return res;
    }
}

/*
这里展示一种嵌套List的错误用法。
本意是everyLevelList只创建一次，之后循环中重复使用。每次向everyLevelList填充完该层所有节点，并且加入到res中后，
可以将everyLevelList清空，以便下一次while循环时，向everyLevelList填充下一层的节点。
但是这样做存在一个问题。因为res.add(everyLevelList)，所以每次清空everyLevelList（即everyLevelList.clear()）
都会使res也为空，使得res之前存储的上一层节点消失，从而产生错误

用下面的代码：
输入：[3,9,20,null,null,15,7]
输出：[[],[],[]]
debug（即程序中的System.out.println）：
[3]
[]
[[3]]
after clear everyLevelList []
after clear res [[]] ------------------->清空everyLevelList,都会使res也为空，使得res之前存储的上一层节点消失
=============================
[9, 20]
[[9, 20]]
[[9, 20], [9, 20]]
after clear everyLevelList []
after clear res [[], []] ------------------->清空everyLevelList,都会使res也为空，使得res之前存储的上一层节点消失
=============================
[15, 7]
[[15, 7], [15, 7]]
[[15, 7], [15, 7], [15, 7]]
after clear everyLevelList []
after clear res [[], [], []] ------------------->清空everyLevelList,都会使res也为空，使得res之前存储的上一层节点消失
=============================
[[], [], []]

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<List<Integer>>();
        }

        //List<List<Integer>> res = new List<>(); // 这种写法是错误的，List是接口，不能new
        //List<List<Integer>> res = new ArrayList<ArrayList<Integer>>() // //这种写法是错误的,因为泛型类型不一致
        List<List<Integer>> res = new ArrayList<List<Integer>>(); // 这种写法是正确的 存放层序遍历的结果
        List<Integer> everyLevelList = new ArrayList<>(); // 存放每一层的元素

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int levelSize = q.size(); // 当前层的元素的个数

            // 一次性处理本层所有元素
            for(int i = 0; i < levelSize; i++) {
                TreeNode cur = q.poll();
                everyLevelList.add(cur.val);
                // 向队列添加下一层的元素
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if(cur.right != null) {
                    q.offer(cur.right);
                }
            }
            System.out.println(everyLevelList);
            System.out.println(res);
            res.add(everyLevelList);
            System.out.println(res);
            everyLevelList.clear();
            System.out.println("after clear everyLevelList " + everyLevelList);
            System.out.println("after clear res " + res);
            System.out.println("=============================");
        }
        System.out.println(res);
        return res;
    }
}
 */