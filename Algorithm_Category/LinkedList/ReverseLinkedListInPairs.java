package LinkedList;

/**
 * Reverse pairs of elements in a singly-linked list.
 *
 * Examples:
    L = null, after reverse is null
    L = 1 -> null, after reverse is 1 -> null
    L = 1 -> 2 -> null, after reverse is 2 -> 1 -> null
    L = 1 -> 2 -> 3 -> null, after reverse is 2 -> 1 -> 3 -> null
 */

//Time: O(n), Space: O(1)
//public class ReverseLinkedListInPairs {
//    public ListNode reverseInPairs(ListNode head) {
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        ListNode cur = dummy;
//        while (cur.next != null && cur.next.next != null) {
//            ListNode next = cur.next.next;
//            cur.next.next = next.next;
//            next.next = cur.next;
//            cur.next = next;
//            cur = cur.next.next;
//        }
//        return dummy.next;
//    }
//}

//Time: O(m), Space: O(n)
public class ReverseLinkedListInPairs {
    public ListNode reverseInPairs(ListNode head) {
         if (head == null || head.next == null) { // recursion way
           return head;
         }

         ListNode next = head.next;
         head.next = reverseInPairs(head.next.next);
         next.next = head;
         return next;
    }
}
