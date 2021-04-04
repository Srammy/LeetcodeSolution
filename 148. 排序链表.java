/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode temp = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(temp);

        ListNode newHead = new ListNode(0);
        ListNode p = newHead;
        while (left != null && right != null) {
            if (left.val < right.val) {
                p.next = left;
                left = left.next;
                p = p.next;
            } else {
                p.next = right;
                right = right.next;
                p = p.next;
            }
        }

        while (left != null) {
            p.next = left;
            left = left.next;
            p = p.next;
        }

        while (right != null) {
            p.next = right;
            right = right.next;
            p = p.next;
        }

        return newHead.next;
    }
}