/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution1 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        while (lenA > 0 && lenB > 0) {
            if (lenA > lenB) {
                headA = headA.next;
                lenA--;
            } else if (lenA < lenB) {
                headB = headB.next;
                lenB--;
            } else {
                if (headA == headB) {
                    return headA;
                }
                headA = headA.next;
                lenA--;
                headB = headB.next;
                lenB--;
            }
        }
        return null;
    }
    
    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}


public class Solution2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode currA = headA;
        ListNode currB = headB;
        while (currA != currB) {
            currA = currA != null ? currA.next : headB;
            currB = currB != null ? currB.next : headA;
        }
        return currA;
    }
}
