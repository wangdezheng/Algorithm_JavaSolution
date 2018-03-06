package Tree;

import java.util.HashSet;

/**
 * Given a binary tree in which each node contains an integer number. Determine if there exists a path from any node to
 * any node(the two nodes can be the same node and they can only be on the path from root to one of the leaf nodes), the
 * sum of the numbers on the path is equal to the given target number.
 *
 * Examples:
 *             -5

             /    \

           2      11

                /    \

               6     14
 *
 *          /   \
 *
 *         8    10
 *
 *  If target = 17, there exists a path 11 + 6, the sum of the path is target.
 *  If target = 100, there does not exist any paths sum of which is target.
 */
//Time: O(n), Space: O(n)
public class PathSumEqualToGivenTargetNumber {
    public boolean pathSumTarget(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        HashSet<Integer> prefixSumSet = new HashSet<>();
        prefixSumSet.add(0);
        return pathSumTarget(root, prefixSumSet, root.key, target);
    }

    private boolean pathSumTarget(TreeNode root, HashSet<Integer> prefixSumSet, int prefixSum, int target) {
        prefixSum += root.key;
        if (prefixSumSet.contains(prefixSum - target)) {
            return true;
        }
        boolean needRemove = prefixSumSet.add(prefixSum);
        if (root.left != null && pathSumTarget(root.left, prefixSumSet, prefixSum, target)) {
            return true;
        }
        if (root.right != null && pathSumTarget(root.left, prefixSumSet, prefixSum, target)) {
            return true;
        }
        //don't forget for the cleanup when return to the previous level
        if (needRemove) {
            prefixSumSet.remove(prefixSum);
        }
        return false;
    }
}
