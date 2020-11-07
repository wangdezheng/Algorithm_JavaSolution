package LinkedList;

/**
 You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.  

 Example:
     Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     Output: 7 -> 0 -> 8
 */

public class AddTwoNumbers {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(0);
    ListNode cur = dummyHead;
    int temp = 0;
    while (l1 != null || l2 != null) {
      if (l1 != null) {
        temp += l1.value;
        l1 = l1.next;
      }
      if (l2 != null) {
        temp += l2.value;
        l2 = l2.next;
      }
      cur.next = new ListNode(temp % 10);
      cur = cur.next;
      temp = temp / 10;
    }
    if (temp != 0) {
      cur.next = new ListNode(temp);
    }
    return dummyHead.next;
  }
}
