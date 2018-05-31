/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode curr = head, newCurr = dummy;
        while (curr != null) {
            newCurr.next = new RandomListNode(curr.label);
            map.put(curr, newCurr.next);
            curr = curr.next;
            newCurr = newCurr.next;
        }
        curr = head;
        newCurr = dummy;
        while (curr != null) {
            newCurr.next.random = map.get(curr.random);
            curr = curr.next;
            newCurr = newCurr.next;
        }
        return dummy.next;
    }
}
