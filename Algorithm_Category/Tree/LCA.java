package Tree;

/**
 * Given two nodes in a binary tree, find their lowest common ancestor.
 * Assumptions:
 * There is no parent pointer for the nodes in the binary tree
 * The given two nodes are guaranteed to be in the binary tree
 */

public class LCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
        if (root == null || root == one || root == two) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, one, two);
        TreeNode right = lowestCommonAncestor(root.right, one, two);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
}
