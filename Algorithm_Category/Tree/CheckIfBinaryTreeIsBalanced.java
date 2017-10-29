package Tree;

/**
 * Check if a given binary tree is balanced. A balanced binary tree is one in which the depths of every node’s left and right subtree differ by at most 1.
 */
// Time: O(n), Space: O(1)
public class CheckIfBinaryTreeIsBalanced {
    public boolean isBalanced(TreeNode root) {
        int val = helper(root);
        return val != -1;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        if (left == -1 || right == -1) {
            return -1;
        }
        if (Math.abs(left - right) <= 1) {
            return Math.max(left, right) + 1;
        } else {
            return -1;
        }
    }
}
