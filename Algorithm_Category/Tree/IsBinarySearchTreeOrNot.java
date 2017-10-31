package Tree;

/**
 * Determine if a given binary tree is binary search tree.
 * <p>
 * Assumptions
 * <p>
 * There are no duplicate keys in binary search tree.
 * You can assume the keys stored in the binary search tree can not be Integer.MIN_VALUE or Integer.MAX_VALUE.
 * Corner Cases
 * <p>
 * What if the binary tree is null? Return true in this case.
 */

//Time: O(n), Space: O(height);
public class IsBinarySearchTreeOrNot {
    public boolean isBST(TreeNode root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.key <= min || root.key >= max) {
            return false;
        }
        return isBST(root.left, min, root.key) && isBST(root.right, root.key, max);
    }
}
