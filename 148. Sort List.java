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
        int length = getLength(head);
        return sortList(head, length);
    }
    
    private ListNode sortList(ListNode head, int length) {
        if (length <= 1) {
            return head;
        }
        ListNode curr = head;
        int mid = length / 2;
        for (int i = 0; i < mid - 1; i++) {
            curr = curr.next;
        }
        ListNode tail = curr.next;
        curr.next = null;
        return merge(sortList(head, mid), sortList(tail, length - mid));
    }
    
    private ListNode merge(ListNode head, ListNode tail) {
        ListNode result = null, curr = null;
        while (head != null || tail != null) {
            boolean shouldAddHead = tail == null || (head != null && head.val < tail.val);
            ListNode next = shouldAddHead ? head : tail;
            if (result == null) {
                result = next;
                curr = next;
            } else {
                curr.next = next;
                curr = curr.next;
            }
            if (shouldAddHead) {
                head = head.next;
            } else {
                tail = tail.next;
            }
        }
        curr.next = null;
        return result;
    }
    
    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
