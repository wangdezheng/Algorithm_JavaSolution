package LinkedList;

/**

 Remove all elements from a linked list of integers that have value val.

 Example:
  Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
  Return: 1 --> 2 --> 3 --> 4 --> 5
 */

public class RemoveLinkedListElements {
  public ListNode removeElements(ListNode head, int val) {
    if (head == null) {
      return head;
    }
    ListNode dummyHead = new ListNode(0);
    dummyHead.next = head;
    ListNode cur = head;
    ListNode pre = dummyHead;
    ListNode next = head.next;
    while (cur != null) {
      next = cur.next;
      if (cur.value == val) {
        pre.next = next;
      } else {
        pre = cur;
      }
      cur = next;
    }
    return dummyHead.next;
  }
}
