package BFS;

import Tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Get the list of keys in a given binary tree layer by layer in zig-zag order.
 * 5
 * /   \
 * 3     8
 * /  \     \
 * 1    4     11
 * the result is [5, 3, 8, 11, 4, 1]
 */
//Time: O(n), Space:O(n)
public class GetKeysInBinaryTreeLayerByLayerZigZagOrder {
    public List<Integer> zigZag(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerFirst(root);
        int layer = 1;
        while (!deque.isEmpty()) {
            int count = deque.size();
            TreeNode cur;
            if (layer % 2 != 0) {   //case one: layer is odd
                for (int i = 0; i < count; i++) {
                     cur = deque.pollLast();
                    result.add(cur.key);
                    if (cur.right != null) {
                        deque.offerFirst(cur.right);
                    }
                    if (cur.left != null) {
                        deque.offerFirst(cur.left);
                    }
                }
            } else {  //case two: layer is even
                for (int i = 0; i < count; i++) {
                    cur = deque.pollFirst();
                    result.add(cur.key);
                    if (cur.left != null) {
                        deque.offerLast(cur.left);
                    }
                    if (cur.right != null) {
                        deque.offerLast(cur.right);
                    }
                }
            }
            layer++;
        }
        return result;
    }
}
