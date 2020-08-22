/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode p = newHead;
        // 循环结束后，p指向m的前一个节点
        for (int i = 1; i < m; i++) {
             p = p.next;
        }

        ListNode pre = null; 
        ListNode cur = p.next; // 当前处理的节点
        ListNode temp = null;
        
        for (int i = m; i <= n; i++) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        p.next.next = temp;
        p.next = pre;
        return newHead.next;
    }
}