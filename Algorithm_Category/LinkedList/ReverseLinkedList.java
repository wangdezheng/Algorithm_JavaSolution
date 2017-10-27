package LinkedList;

public class ReverseLinkedList {
//    public ListNode reverseLinkedList(ListNode head){
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode newHead = reverseLinkedList(head.next);
//        head.next.next = head;
//        head.next = null;
//        return  newHead;
//    }

    public ListNode reverseLinkedList(ListNode head){
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null || cur.next != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
