package leetcode.practice.List;

import google.com.linkedlist.ListNode;

public class SwapNodesPairs {
    public ListNode swapPairs(ListNode head) {

        ListNode temp = head;
        if (head != null && head.next != null) {
            head = head.next;
        }
        ListNode prev = null;
        while (temp != null && temp.next != null) {
            ListNode next = temp.next;
            temp.next = next.next;
            next.next = temp;

            if (prev!=null) {
                prev.next = next;
            }

            prev = temp;
            temp = temp.next;
        }
        return head;
    }
}
