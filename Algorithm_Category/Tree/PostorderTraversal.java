package Tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.ArrayList;

// root.left-> root.right-> root
// Time: O(n) Space: O(Height)
public class PostorderTraversal {
    public List<Integer> postOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode pre = null;
        stack.offerFirst(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peekFirst();
            if (pre == null || cur == pre.left || cur == pre.right) { // top to bottom
                if (cur.left != null) { // left child is not null
                    stack.offerFirst(cur.left);
                } else if (cur.right != null) { // right child is not null
                    stack.offerFirst(cur.right);
                } else { // left and right child are null
                    result.add(cur.key);
                    stack.pollFirst();
                }
            } else if (pre == cur.left) { // left to root
                if (cur.right != null) {  // right is not null
                    stack.offerFirst(cur.right);
                } else {  // right is null
                    result.add(cur.key);
                    stack.pollFirst();
                }
            } else if (pre == cur.right) { // right to root
                result.add(cur.key);
                stack.pollFirst();
            }
            pre = cur;
        }
        return result;
    }
}
