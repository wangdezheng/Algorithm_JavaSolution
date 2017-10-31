package Tree;

/**
 * Insert a key in a binary search tree if the binary search tree does not already contain the key. Return the root of the binary search tree.
 * <p>
 * Assumptions
 * <p>
 * There are no duplicate keys in the binary search tree
 * <p>
 * If the key is already existed in the binary search tree, you do not need to do anything
 */
// Time: O(Height), Space: O(Height)
public class InsertInBST {
    //iterative way
    public TreeNode insert(TreeNode root, int key) {
        TreeNode node = new TreeNode(key);
        if (root == null) {
            return node;
        }
        TreeNode cur = root;
        while (cur.key != key) {
            if (cur.key > key) { // target is in the left subtree
                if (cur.left == null) {
                    cur.left = node;
                    break;
                } else {
                    cur = cur.left;
                }
            } else { //target is in the right subtree
                if (cur.right == null) {
                    cur.right = node;
                    break;
                } else {
                    cur = cur.right;
                }
            }
        }
        return root;
    }

    //recursion way
//    public TreeNode insert(TreeNode root, int key) {
//        if (root == null) {
//            return new TreeNode(key);
//        }
//        return helper(root, key);
//    }
//
//    private TreeNode helper(TreeNode root, int key) {
//        if (root.key > key) { // target is in the left subtree
//            if (root.left == null) {
//                root.left = new TreeNode(key);
//            } else {
//                root.left = helper(root.left, key);
//            }
//        } else if (root.key < key) {  //target is in the right subtree
//            if (root.right == null) {
//                root.right = new TreeNode(key);
//            } else {
//                root.right = helper(root.right, key);
//            }
//        }
//        return root;
//    }
}
