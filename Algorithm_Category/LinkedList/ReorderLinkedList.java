package LinkedList;

/**
 * Reorder the given singly-linked list N1 -> N2 -> N3 -> N4 -> … -> Nn -> null to be N1- > Nn -> N2
 * -> Nn-1 -> N3 -> Nn-2 -> … -> null
 *
 * <p>Examples: L = null, is reordered to null L = 1 -> null, is reordered to 1 -> null L = 1 -> 2
 * -> 3 -> 4 -> null, is reordered to 1 -> 4 -> 2 -> 3 -> null L = 1 -> 2 -> 3 -> null, is reordred
 * to 1 -> 3 -> 2 -> null
 */
public class ReorderLinkedList {
  public ListNode reorder(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode middleNode = findMiddle(head);
    ListNode reversedList = reverse(middleNode.next);
    middleNode.next = null;
    ListNode newHead = mergeTwoList(head, reversedList);
    return newHead;
  }

  private ListNode findMiddle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }

  private ListNode reverse(ListNode head) {
    if (head.next == null) {
      return head;
    }
    ListNode newHead = reverse(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
  }

  private ListNode mergeTwoList(ListNode left, ListNode right) {
    ListNode dummyHead = new ListNode(0);
    ListNode cur = dummyHead;
    boolean addFirst = true;
    while (left != null && right != null) {
      if (addFirst) {
        cur.next = left;
        left = left.next;
      } else {
        cur.next = right;
        right = right.next;
      }
      addFirst = !addFirst;
      cur = cur.next;
    }
    if (left != null) {
      cur.next = left;
    }
    if (right != null) {
      cur.next = right;
    }
    return dummyHead.next;
  }
}
