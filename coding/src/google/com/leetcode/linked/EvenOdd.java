//package google.com.leetcode.linked;
//
//public class EvenOdd {
//    public ListNode oddEvenList(ListNode head) {
//        ListNode node = new ListNode(0);
//        ListNode temp = node;
//
//        ListNode nextHead = null;
//        if(head != null)
//            nextHead = head.next;
//
//        while (head != null){
//            temp.next = new ListNode(head.val);
//            temp = temp.next;
//            if(head.next != null && head.next.next != null)
//                head = head.next.next;
//            else
//                break;
//        }
//
//        while (nextHead != null){
//            temp.next = new ListNode(nextHead.val);
//            temp = temp.next;
//            if(nextHead.next != null && nextHead.next.next != null)
//                nextHead = nextHead.next.next;
//            else
//                break;
//        }
//        if(node.next == null)
//            return head;
//        return node.next;
//    }
//}
//
//class ListNode {
//    int val;
//    ListNode next;
//    ListNode() {}
//    ListNode(int val) { this.val = val; }
//    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}
//
//class Solution {
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        return helper(0,0,inorder.length-1, preorder, inorder);
//    }
//
//    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
//        if (preStart > preorder.length - 1 || inStart > inEnd) {
//            return null;
//        }
//        TreeNode root = new TreeNode(preorder[preStart]);
//        int inIndex = 0; // Index of current root in inorder
//        for (int i = inStart; i <= inEnd; i++) {
//            if (inorder[i] == root.val) {
//                inIndex = i;
//            }
//        }
//        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
//        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
//        return root;
//    }
//}