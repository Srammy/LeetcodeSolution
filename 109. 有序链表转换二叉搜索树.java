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
 //-------------------------------my method------------------------------
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        ListNode p = head;

        // 寻找链表的中间节点 
		// 当链表的长度是奇数时，slow恰巧停在中点位置；如果长度是偶数，slow最终的位置是中间偏右
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 将链表以中间节点为准，分为左右两部分
        // 左边链表的头结点是head，下面的循环操作是为了把左边链表的最后一个节点的next设为null
        // 右边链表的头节点是slow.next
        while (p.next != null && p.next != slow) { // 找slow的前一个节点
            p = p.next;
        }
        p.next = null;

        TreeNode root = new TreeNode(slow.val);
        if (slow == fast) { // 只有一个节点（slow == fast）,此时左子树为null
            root.left = null; 
        } else {
            root.left = sortedListToBST(head);
        }  
        root.right = sortedListToBST(slow.next); // 只有一个节点时，slow.next == null,直接返回null（代码第一行），root.right == null
        return root;
    }
}