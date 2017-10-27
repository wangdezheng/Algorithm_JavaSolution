package Tree;
import java.util.Set;

/**
 * Given k nodes in a binary tree, find their lowest common ancestor.
 * Assumptions:
 * There is no parent pointer for the nodes in the binary tree
 * The given k nodes are guaranteed to be in the binary tree
 */

public class LCAForKNodes {
    public TreeNode KNodesInLCA(TreeNode root, Set<TreeNode> nodes) {
        if (root == null || nodes.contains(root)) {
            return root;
        }
        TreeNode left = KNodesInLCA(root.left, nodes);
        TreeNode right = KNodesInLCA(root.right, nodes);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
}
