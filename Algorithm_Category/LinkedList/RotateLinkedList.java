package LinkedList;

/**
 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。

 示例 1:
    输入: 1->2->3->4->5->NULL, k = 2
    输出: 4->5->1->2->3->NULL
    解释:
      向右旋转 1 步: 5->1->2->3->4->NULL
      向右旋转 2 步: 4->5->1->2->3->NULL
 */
public class RotateLinkedList {
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null) {
      return head;
    }
    int len = 1;
    ListNode tail = head;
    while (tail.next != null) {
      tail = tail.next;
      len++;
    }
    tail.next = head;
    int realMove = k % len;
    ListNode cur = head;
    ListNode pre = tail;
    int count = 1;
    while (count <= len - realMove) {
      pre = cur;
      cur = cur.next;
      count++;
    }
    pre.next = null;
    return cur;
  }
}
