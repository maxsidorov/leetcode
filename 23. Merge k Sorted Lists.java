// My solution, O(N*K)
class Solution1 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        ListNode result = lists[0];
        for (int i = 1; i < lists.length; i++) {
            result = mergeTwoLists(result, lists[i]);
        }
        return result;
    }
    
    private ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null) return b;
        if (b == null) return a;
        ListNode head;
        if (a.val < b.val) {
            head = a;
            a = a.next;
        } else {
            head = b;
            b = b.next;
        }
        ListNode curr = head;
        while (a != null || b != null) {
            if (b == null || (a != null && a.val < b.val)) {
                curr.next = a;
                curr = a;
                a = a.next;
            } else {
                curr.next = b;
                curr = b;
                b = b.next;
            }
        }
        return head;
    }
}



// My improved solution, O(N logK)
class Solution2 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        int length = lists.length;
        while (length > 1) {
            for (int i = 0; i < length / 2; i++) {
                lists[i] = mergeTwoLists(lists[i], lists[(length + 1) / 2 + i]);
            }
            length = (length + 1) / 2;
        }
        return lists[0];
    }
    
    private ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (a != null || b != null) {
            if (b == null || (a != null && a.val < b.val)) {
                curr.next = a;
                curr = a;
                a = a.next;
            } else {
                curr.next = b;
                curr = b;
                b = b.next;
            }
        }
        return dummy.next;
    }
}

// Solution with priority queue, O(N logK)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((n1, n2) -> n1.val - n2.val);
        for (ListNode node: lists) {
            if (node != null) {
                pq.add(node);
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            curr.next = node;
            curr = node;
            if (node.next != null) {
                pq.add(node.next);
            }
        }
        return dummy.next;
    }
}
