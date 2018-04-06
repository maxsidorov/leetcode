/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("Slow = " + slow.val + slow.next.val);
        slow = slow.next;
        
        ListNode next = slow.next;
        slow.next = null;
        while (next != null) {
            ListNode nextNext = next.next;
            next.next = slow;
            slow = next;
            next = nextNext;
        }
        
        while (slow != null) {
            if (slow.val != head.val) {
                return false;
            }
            slow = slow.next;
            head = head.next;
        }
        
        return true;
        
        
    }
}
