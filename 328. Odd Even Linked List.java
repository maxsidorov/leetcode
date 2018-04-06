/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution1 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return head;
        ListNode odd = head, even = head.next, curr = head.next.next, evenHead = even;
        while (curr != null) {
            odd.next = curr;
            odd = curr;
            curr = curr.next;
            
            if (curr != null) {
                even.next = curr;
                even = curr;
                curr = curr.next;
            }
        }
        even.next = null;
        odd.next = evenHead;
        return head;
    }
}

class Solution2 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;
        ListNode odd = head, even = head.next, evenHead = even;
        while (odd.next != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
