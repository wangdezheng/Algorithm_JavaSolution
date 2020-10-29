package LinkedList;

/**
 Find the middle node of a given linked list.

 Examples:
     L = null, return null
     L = 1 -> null, return 1
     L = 1 -> 2 -> null, return 1
     L = 1 -> 2 -> 3 -> null, return 2
     L = 1 -> 2 -> 3 -> 4 -> null, return 2
 */

public class MiddleNodeOfLinkedList {
  public ListNode middleNode(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode fast = head;
    ListNode slow = head;
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }
}
