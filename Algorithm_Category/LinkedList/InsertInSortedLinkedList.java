package LinkedList;

/**
 Insert a value in a sorted linked list.

 Examples
    L = null, insert 1, return 1 -> null
    L = 1 -> 3 -> 5 -> null, insert 2, return 1 -> 2 -> 3 -> 5 -> null
    L = 1 -> 3 -> 5 -> null, insert 3, return 1 -> 3 -> 3 -> 5 -> null
    L = 2 -> 3 -> null, insert 1, return 1 -> 2 -> 3 -> null
 */

public class InsertInSortedLinkedList {
  public ListNode insert(ListNode head, int value) {
    ListNode node = new ListNode(value);
    if (head == null) {
      return node;
    }
    if (value < head.value) {
      node.next = head;
      return node;
    }
    ListNode cur = head.next;
    ListNode pre = head;;
    while (cur != null) {
      if (value < cur.value) {
        node.next = cur;
        pre.next = node;
        return head;
      }
      pre = cur;
      cur = cur.next;
    }
    pre.next = node;
    return head;
  }
}
