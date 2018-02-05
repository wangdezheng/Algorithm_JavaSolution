package LinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * Each of the nodes in the linked list has another pointer pointing to a random node in the list or null. Make a deep copy of the original list.
 */
//Time: O(n), Space: O(n)
public class DeepCopyLinkedListWithRandomPointer {
    public ListNode cloneLinkedList(ListNode head) {
        if (head == null) {
            return null;
        }
        Map<ListNode, ListNode> lookup = new HashMap<>();
        ListNode newHead = new ListNode(head.value);
        ListNode cur = newHead;
        while (head != null) {
            if (head.next != null) {
                if (!lookup.containsKey(head.next)) {
                    lookup.put(head.next, new ListNode(head.next.value));
                }
                cur.next = lookup.get(head.next);
            }
            if (head.random != null) {
                if (!lookup.containsKey(head.random)) {
                    lookup.put(head.random, new ListNode(head.random.value));
                }
                cur.random = lookup.get(head.random);
            }
            head = head.next;
            cur = cur.next;
        }
        return newHead;
    }
}
