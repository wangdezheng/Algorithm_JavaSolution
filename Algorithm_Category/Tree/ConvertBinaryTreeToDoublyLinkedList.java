package Tree;

/**
 * Given a binary tree, convert it to a doubly linked list in in-order sequence.
 *
 * Example:
 *                 10

                 /    \

               5      15

            /   \    /   \

          2     7  12    20

 Output: 2 <-> 5 <-> 7 <-> 10 <-> 12 <-> 15 <-> 20
 */

//Time: O(n), Space: O(Height)
//Key points: 1. Never lose control over the head pointer; 2. Need to record the previous node
public class ConvertBinaryTreeToDoublyLinkedList {
    public ListNode binaryTree2DoublyLinkedList(TreeNode root) {
        if (root == null) {
            return null;
        }
        ListNode head = null;
        ListNode pre = null;
        binaryTree2DoublyLinkedList(root.left, head, pre);
        return head;
    }

    private void binaryTree2DoublyLinkedList(TreeNode root, ListNode head, ListNode pre) {
        if (root == null) {
            return;
        }
        binaryTree2DoublyLinkedList(root.left, head, pre);
        if (pre == null) {
            head = new ListNode(root.key);
        } else {
            ListNode cur = new ListNode(root.key);
            cur.pre = pre;
            pre.next = cur;
        }
        pre = new ListNode(root.key);
        binaryTree2DoublyLinkedList(root.right, head, pre);
    }
}

class ListNode {
    int value;
    ListNode next;
    ListNode pre;

    public ListNode(int value) {
        this.value = value;
        next = null;
        pre = null;
    }
}
