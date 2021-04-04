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
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode p = head;

        Stack<ListNode> stack = new Stack<>();

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode mid = slow;

        while (mid != null) {
            stack.push(mid);
            mid = mid.next;
        }

        while (p != slow) {
            if (p.val != stack.pop().val) {
                return false;
            }
            p = p.next;
        }

        return true;
    }
}