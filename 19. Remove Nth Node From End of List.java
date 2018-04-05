/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        ListNode node = head;
        while (curr.next != null) {
            curr = curr.next;
            if (n-- < 1) {
                node = node.next;
            }
        }
        
        if (n == 1) {
            return head.next;
        }
        node.next = node.next.next;
        return head;
    }
}
