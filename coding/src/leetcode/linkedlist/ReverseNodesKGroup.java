package leetcode.linkedlist;

import google.com.linkedlist.ListNode;

public class ReverseNodesKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        int count = 0;

        while (head != null) {
            count = 0;
            ListNode node = new ListNode(0);
            ListNode tempNode = node;
            while (count++<k && head!=null) {
                tempNode.next = head;
                head = head.next;
                tempNode = tempNode.next;
            }
            tempNode.next = null;
            node = node.next;
            if (count > k) {
                System.out.println(count+" "+k);
                temp.next = reverseNode(node);
            } else {
                temp.next = node;
            }

            while (temp.next!=null) {
                temp = temp.next;
            }
        }

        return result.next;
    }

    private ListNode reverseNode(ListNode next) {
        ListNode print = next;
        while (print!=null) {
            System.out.print(print.val+" ");
            print = print.next;
        }
        System.out.println();


        ListNode curr = null;
        ListNode temp = null;

        while (next != null) {
            temp = next;
            next = next.next;
            temp.next = curr;
            curr = temp;
        }
        return curr;
    }
}
