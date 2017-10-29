package Tree;

/**
 * Check if a given binary tree is symmetric.
 Examples
        5
    /       \
    3        3
  /   \    /   \

 1    4   4     1
 */

// Time: O(n), Space: O(1)
public class IsSymmetricBinaryTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else if (left.key != right.key) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
