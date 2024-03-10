package google.com.linkedlist;

public class Reverse {
    Node reverseList(Node head)
    {
        Node temp = null;

        while (head != null){
            Node currNode = head;
            head = head.next;
            currNode.next = temp;
            temp = currNode;
        }

        return temp;
    }
}
