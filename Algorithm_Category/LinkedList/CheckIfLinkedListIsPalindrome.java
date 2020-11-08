package LinkedList;

/**
 Given a linked list, check whether it is a palindrome.

 Examples:
   Input:   1 -> 2 -> 3 -> 2 -> 1 -> null
   output: true.
   Input:   1 -> 2 -> 3 -> null  
   output: false.

 Requirements:
   Space complexity must be O(1)
 */

public class CheckIfLinkedListIsPalindrome {
  public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) {
      return true;
    }
    ListNode middle = findMiddle(head);
    ListNode right = middle.next;
    middle.next = null;
    ListNode reversed = reverse(right);
    while (head != null && reversed != null) {
      if (head.value != reversed.value) {
        return false;
      }
      head = head.next;
      reversed = reversed.next;
    }
    return true;
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
    ListNode cur = head;
    ListNode next = null;
    ListNode pre = null;
    while (cur != null) {
      next = cur.next;
      cur.next = pre;
      pre = cur;
      cur = next;
    }
    return pre;
  }
}
