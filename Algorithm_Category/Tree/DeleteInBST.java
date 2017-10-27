package Tree;

/**
 * Delete the target key K in the given binary search tree if the binary search tree contains K. Return the root of the binary search tree.
 * <p>
 * Find your own way to delete the node from the binary search tree, after deletion the binary search tree's property should be maintained.
 */

//Time: O(n) Space: O(1)
public class DeleteInBST {
    public TreeNode delete(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.key == key) {  // find target
            if (root.left == null) {  // left subtree is null or both left and right are null
                return root.right;
            }
            if (root.right == null) { //right subtree is null
                return root.left;
            }
            if (root.right.left == null) { // under root.left != null && root.right != null
                root.right.left = root.left;
                return root.right;
            }
            TreeNode smallest = findSmallestInRight(root.right);
            smallest.left = root.left;
            smallest.right = root.right;
            return smallest;
        } else if (root.key < key) { // go down right subtree
            root.right = delete(root.right, key);
        } else { // go down left subtree
            root.left = delete(root.left, key);
        }
        return root;
    }

    private TreeNode findSmallestInRight(TreeNode cur) {
        while (cur.left.left != null) {
            cur = cur.left;
        }
        TreeNode smallest = cur.left;
        cur.left = cur.left.right;
        return smallest;
    }
}
