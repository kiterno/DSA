package google.com.linkedlist;

public class RemoveDupe {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode finalResult = new ListNode(0, head);
        ListNode pre = finalResult;

        while (head!=null) {
            if(head.next!=null && head.next.val == head.val) {
                while (head.next!=null && head.next.val == head.val) {
                    head = head.next;
                }
                pre.next = head.next;
            }
            else {
                pre = pre.next;
            }
            head = head.next;
        }

        return finalResult.next;
    }
}
