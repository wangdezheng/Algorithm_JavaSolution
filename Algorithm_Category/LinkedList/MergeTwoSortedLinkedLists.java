package LinkedList;

/**
 Merge two sorted lists into one large sorted list.

 Examples:
    L1 = 1 -> 4 -> 6 -> null, L2 = 2 -> 5 -> null, merge L1 and L2 to 1 -> 2 -> 4 -> 5 -> 6 -> null
    L1 = null, L2 = 1 -> 2 -> null, merge L1 and L2 to 1 -> 2 -> null
    L1 = null, L2 = null, merge L1 and L2 to null
 */

public class MergeTwoSortedLinkedLists {
 public ListNode merge(ListNode one, ListNode two) {
    if (one == null) {
      return two;
    }
    if (two == null) {
      return one;
    }
    ListNode dummyHead = new ListNode(0);
    ListNode pre = dummyHead;
    while (one != null && two != null) {
      if (one.value < two.value) {
        pre.next = one;
        pre = one;
        one = one.next;
      } else {
        pre.next = two;
        pre = two;
        two = two.next;
      }
    }
    if (one == null ){
      pre.next = two;
    }
    if (two == null) {
      pre.next = one;
    }
    return dummyHead.next;
  }
}
