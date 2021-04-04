/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
//-------------方法1：迭代--------------
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(-1);
        ListNode p = newHead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
                p = p.next;
            } else {
                p.next = l2;
                l2 = l2.next;
                p = p.next;
            }
        }

        while (l1 != null) {
            p.next = l1;
            l1 = l1.next;
            p = p.next;
        }

        while (l2 != null) {
            p.next = l2;
            l2 = l2.next;
            p = p.next;
        }

        return newHead.next;
    }
}
//-------------------方法2：递归---------------------
class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }
	
}