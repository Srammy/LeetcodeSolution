/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode newHead = new ListNode(-1);
        newHead.next = head;

        ListNode p = newHead; // 当前正在处理的k个节点的前一个结点
		
        ListNode pre = new ListNode(0);
        ListNode cur = head;
        ListNode temp = null;

        ListNode checkNode = cur;
        
        for (int i = 0; i < k - 1; i++) {
            if (checkNode != null) checkNode = checkNode.next;
            else break;
        }

        while (cur != null && checkNode != null) {
			// 反转K个结点
            for (int i = 0; i < k; i ++) {
                temp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = temp;
            }
			
			// 重新构成链表
            p.next.next = temp;
            p.next = pre;

			// 为下一次反转k个结点做准备
            for(int j = 0; j < k - 1; j++) {
                pre = pre.next;
            }
            p = pre;
            pre = null;
            
            checkNode = cur;
            for (int i = 0; i < k - 1; i++) {
                if (checkNode != null) checkNode = checkNode.next;
                else break;
            }
        }
        
        return newHead.next;
    }
}