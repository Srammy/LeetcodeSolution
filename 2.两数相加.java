/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }
        ListNode h1 = l1;
        ListNode h2 = l2;
        ListNode res = new ListNode(0);
        ListNode p = res;
        int flag = 0;
        while(h1 != null || h2 != null) {
            int val1 = h1 != null ? h1.val : 0;
            int val2 = h2 != null ? h2.val : 0;
            int val = val1 + val2 + flag;
            flag = 0;
            if(val >= 10) {
                flag = 1;
                val = val % 10;
            }
            p.next = new ListNode(val);
            p=p.next;
            if (h1 != null) {
                h1 = h1.next;
            }
            if (h2 != null) {
                h2 = h2.next;
            }
        }      
        // 最后一位
        if (flag > 0) {
            p.next = new ListNode(flag);
        }
        return res.next;
    }
}
// @lc code=end

