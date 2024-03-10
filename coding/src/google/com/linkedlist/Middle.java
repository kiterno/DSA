package google.com.linkedlist;

public class Middle {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
