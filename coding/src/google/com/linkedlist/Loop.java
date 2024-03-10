package google.com.linkedlist;

public class Loop {
    public static boolean detectLoop(Node head){
        if(head == null || head.next == null)
            return false;

        Node slow = head, fast = head.next;

        while(slow != null && fast.next != null && fast.next.next != null){
            if(slow == fast){
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
