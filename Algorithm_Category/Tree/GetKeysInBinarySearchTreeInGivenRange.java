package Tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Get the list of keys in a given binary search tree in a given range[min, max] in ascending order, both min and max are inclusive.
 */

//Time: O(n), Space: O(Height)
public class GetKeysInBinarySearchTreeInGivenRange {
    public List<Integer> getRange(TreeNode root, int min, int max) {
        List<Integer> result = new LinkedList<>();
        inOrderTraversal(root, result, min, max);
        return result;
    }

    public void inOrderTraversal(TreeNode root, List<Integer> result, int min, int max) {
        if (root == null) {
            return;
        }
        if (root.key > min) {
            inOrderTraversal(root.left, result, min, max);
        }
        if (root.key >= min && root.key <= max) {
            result.add(root.key);
        }
        if (root.key < max) {
            inOrderTraversal(root.right, result, min, max);
        }
    }
}
