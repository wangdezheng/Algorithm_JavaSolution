package Tree;

/**
 * In a binary search tree, find the node containing the closest number to the given target number.

    Assumptions:
        The given root is not null.
        There are no duplicate keys in the binary search tree.

    Examples:
                        5

                     /    \

                   2      11

                        /    \

                       6     14

        closest number to 4 is 5
        closest number to 10 is 11
        closest number to 6 is 6
 */
//Time: O(n), Space: O(1)
public class ClosestNumberInBST {
    public int closest(TreeNode root, int target) {
        int min = Integer.MAX_VALUE;
        while (root != null) {
            if (root.key == target) {
                return root.key;
            }
            if (Math.abs(min) > Math.abs(root.key - target)) {
                min = root.key - target;
            }
            root = root.key > target ? root.left : root.right;
        }
        return min + target;
    }
}
