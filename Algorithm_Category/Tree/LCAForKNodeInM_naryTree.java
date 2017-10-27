package Tree;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Given k nodes in a m-nary tree, find their lowest common ancestor.
 * Assumptions:
 * There is no parent pointer for the nodes in the m-nary tree
 * The given k nodes are guaranteed to be in the m-nary tree
 */

public class LCAForKNodeInM_naryTree {
    public TreeNode KNodesInMLCA(TreeNode root, Set<TreeNode> nodes) {
        if (root == null || nodes.contains(root)) {
            return root;
        }
        int count = 0;
        TreeNode temp = null;
        for (TreeNode child : root.children) {
            TreeNode n = KNodesInMLCA(child, nodes);
            if (n != null) {
                temp = n;
                count++;
            }
            if (count == 2) {
                return root;
            }
        }
        return temp;
    }

    private class TreeNode {
        public int key;
        public List<TreeNode> children;

        public TreeNode(int key) {
            this.key = key;
            children = new ArrayList<>();
        }
    }
}
