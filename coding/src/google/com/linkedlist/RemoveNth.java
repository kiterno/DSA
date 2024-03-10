package google.com.linkedlist;

public class RemoveNth {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode temp = head;

        while (temp!=null)
        {
            size++;
            temp = temp.next;
        }
        if(size==0 || (size==1&&n==1))
            return head.next;

        size = size - n;
        temp = head;
        ListNode prev = temp;
        while(size-->0) {
            prev = temp;
            temp = temp.next;
        }

        if(prev == temp)
            return head.next;
        prev.next = temp.next;

        return head;
    }
}
