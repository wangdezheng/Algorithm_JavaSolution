package LinkedList;

/**
 *Reverse a singly-linked list.

 Examples:
    L = null, return null
    L = 1 -> null, return 1 -> null
    L = 1 -> 2 -> 3 -> null, return 3 -> 2 -> 1 -> null
 */

//Time: O(n), Space: O(n)
//public class ReverseLinkedList {
//    public ListNode reverseLinkedList(ListNode head){
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode newHead = reverseLinkedList(head.next);
//        head.next.next = head;
//        head.next = null;
//        return  newHead;
//    }

//Time: O(n), Space: O(1)
public class ReverseLinkedList {
    public ListNode reverseLinkedList(ListNode head){
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
