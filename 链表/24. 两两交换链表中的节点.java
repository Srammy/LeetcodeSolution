/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
		// 处理空链表和只有一个节点的情况
        if (head == null || head.next == null) {
            return head;
        }
		 
        ListNode newHead = new ListNode(-1);
        newHead.next = head;

        ListNode p = newHead; // 当前正在处理的成对节点的前一个结点
        ListNode pre = head; // 当前正在处理的成对节点的第一个节点
        ListNode cur = head.next; // 当前正在处理的成对节点的第二个节点
        ListNode temp = null; // 当前正在处理的成对节点的后一个结点

        while (pre != null && cur != null) {
            temp = cur.next; // 保存当前正在处理的成对节点的后一个结点
            p.next = cur; // 当前正在处理的成对节点的前一个结点 指向 当前正在处理的成对节点的第二个节点
            cur.next = pre; // 当前正在处理的成对节点的第二个节点 指向 前正在处理的成对节点的第一个节点（对调）
            pre.next = temp; // 当前正在处理的成对节点的第一个节点 指向 当前正在处理的成对节点的后一个结点 （成链）
            
			// 为下一次循环做准备
            p = pre;
            pre = temp;
            if (pre != null) cur = pre.next;
        }

        return newHead.next;
    }
}