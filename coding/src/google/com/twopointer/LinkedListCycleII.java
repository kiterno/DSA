package google.com.twopointer;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) break;
        }
        if (fast == null || fast.next == null)
            return null;

        while (slow!=head) {
            slow = slow.next;
            head = head.next;
        }
        return slow;
    }
}
