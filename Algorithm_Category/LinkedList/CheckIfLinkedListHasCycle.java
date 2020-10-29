package LinkedList;

/**
 Check if a given linked list has a cycle. Return true if it does, otherwise return false.

 Assumption:
    You can assume there is no duplicate value appear in the linked list.
 */

public class CheckIfLinkedListHasCycle {
  public boolean hasCycle(ListNode head) {
    if (head == null) {
      return false;
    }
    ListNode fast = head;
    ListNode slow = head;
    while (fast.next != null && fast.next.next != null) {
      if (fast.next == slow || fast.next.next == slow) {
        return true;
      }
      slow = slow.next;
      fast = fast.next.next;
    }
    return false;
  }
}
