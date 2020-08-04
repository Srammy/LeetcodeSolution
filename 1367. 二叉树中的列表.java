//本题类似判断一棵树是否是另一颗树的子结构（注意，是子结构，不是子树）。
//可以与剑指offer的JZ17->树的子结构一起分析
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root == null) {
            return false;
        }

        if(head == null) {
            return true;
        }

        return isSub(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    // 从二叉树的任意一个节点开始，是否能和链表匹配
    public boolean isSub(ListNode head, TreeNode node) {
        // 匹配到链表为空，必须先判断链表为空，否则会报错
        if(head == null) {
            return true;
        }

        // 要匹配的树节点为空，则不能继续和链表进行匹配了
        if(node == null) {
            return false;
        }
		
		//if(head == null) {
        //    return true;
        //}
		
        // 值不同，匹配失败
        if(node.val != head.val) {
            return false;
        }
        // 到这里说明，当前树的节点和链表的节点已经匹配了，则继续看当前树节点左右
        // 子树是否和接下来的链表是否匹配
        return isSub(head.next, node.left) || isSub(head.next, node.right);
    }
}