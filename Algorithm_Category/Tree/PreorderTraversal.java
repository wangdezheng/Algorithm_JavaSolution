package Tree;

import java.util.*;

// root-> root.left-> root.right
// Time: O(n) Space: O(Height)
public class PreorderTraversal {
    public List<Integer> preOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (root != null || !stack.isEmpty()) {
            root = stack.pop();
            while (root != null) {
                result.add(root.key);
                stack.push(root.right);
                root = root.left;
            }
        }
        return result;
    }
}
