package leetcode.practice;

import google.com.linkedlist.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       ListNode add = null;
       ListNode temp = new ListNode(0);
       int carry = 0;

       while (l1!=null && l2!=null) {
           int sum = l1.val+l2.val+carry;

           carry = sum/10;
           temp.next = new ListNode(sum%10);
           temp = temp.next;
           if (add == null){
               add = temp;
           }
           l1 = l1.next;
           l2 = l2.next;
       }

        if (l1 == null) l1 = l2;

        while (l1!=null) {
            int sum = carry + l1.val;

            carry = sum/10;
            temp.next = new ListNode(sum%10);
            temp = temp.next;
            l1 = l1.next;
        }

        if (carry>0) {
            temp = new ListNode(carry);
        }

        return add;
    }
}
