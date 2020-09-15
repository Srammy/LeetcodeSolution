/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        Map<Integer, ListNode> resMap = new HashMap<>();
        ListNode p = head;
        int count = 0;
        while(p != null) {
            resMap.put(count, p);
            p = p.next;
            count++;
        }

        ListNode insertNode = null;
        int insertIndex = 0;
        for (int i = 1; i < resMap.size(); i++) {
            insertNode = resMap.get(i);
            insertIndex = i - 1;

            while (insertIndex >= 0 && insertNode.val < resMap.get(insertIndex).val) {
                resMap.put(insertIndex + 1, resMap.get(insertIndex));
                insertIndex--;
            }

            if (insertIndex + 1 != i) {
                resMap.put(insertIndex + 1, insertNode); ;
            }
        }

        int j;
        for (j = 0; j < resMap.size(); j++) {
            if (j != (resMap.size() - 1)) {
                resMap.get(j).next  = resMap.get(j + 1); 
            }                   
        }
        
        resMap.get(resMap.size() - 1).next = null;

        return resMap.get(0);

    }
}