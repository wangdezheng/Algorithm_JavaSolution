package LinkedList;

/**
 Given a singly-linked list, where each node contains an integer value, sort it in ascending order. The merge sort algorithm should be used to solve this problem.

 Examples:
     null, is sorted to null
     1 -> null, is sorted to 1 -> null
     1 -> 2 -> 3 -> null, is sorted to 1 -> 2 -> 3 -> null
     4 -> 2 -> 6 -> -3 -> 5 -> null, is sorted to -3 -> 2 -> 4 -> 5 -> 6
 */
public class MergeSortLinkedLIst {
  public ListNode mergeSort(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode middle = findMiddle(head);
    ListNode rightHead = middle.next;
    middle.next = null;
    ListNode left = mergeSort(head);
    ListNode right = mergeSort(rightHead);
    ListNode newHead = merge(left, right);
    return newHead;
  }
  private ListNode findMiddle(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }
  private ListNode merge(ListNode left, ListNode right) {
    ListNode dummyHead = new ListNode(0);
    ListNode cur = dummyHead;
    while (left != null && right != null) {
      if (left.value < right.value) {
        cur.next = left;
        left = left.next;
      } else {
        cur.next = right;
        right = right.next;
      }
      cur = cur.next;
    }
    if (left == null) {
      cur.next = right;
    }
    if (right == null) {
      cur.next = left;
    }
    return dummyHead.next;
  }
}
