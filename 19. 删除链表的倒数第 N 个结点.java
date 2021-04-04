//------------------方法1：两次遍历----------------
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n <= 0) {
            return null;
        }

        int len = 0;
        ListNode p = head;
        int time = 0;
        while (p != null) {
            len++;
            p = p.next;
        }

        if (n == len) {
            head = head.next;
            return head;
        }

        p = head;
        while (time < (len - n - 1)) {
            time++;
            p=p.next;
        }

        p.next = p.next.next;

        return head;

    }
}
//------------------------方法2；快慢指针--------------------------------
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 0) return null;
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode fast = newHead;
        ListNode slow = newHead;
        
        for(int i = 0 ; i < n + 1 ; i ++){
            fast = fast.next;
        }
        
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
  
        slow.next = slow.next.next;

        return newHead.next;
    }
}