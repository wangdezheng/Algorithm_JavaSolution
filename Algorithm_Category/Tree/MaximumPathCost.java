package Tree;

/**
 * Find the maximum path cot for all paths from leaf to root in a Binary Tree.
 * Examples:
            -1

          /    \

        2      11

      /   \

     6    -14
 *
 *  There are three leaf to node paths: 6->2->-1, -14->2->-1, 11->-1. The sum of the three paths are 7, -13, 10 respectively.
 *  The maximum is 11->-1
 */

public class MaximumPathCost {
    public int getMaxPath(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int[] max = new int[]{Integer.MIN_VALUE};
        maxPath(root, 0, max);
        return max[0];
    }

    private void maxPath(TreeNode root, int prefixSum, int[] max) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            max[0] = Math.max(max[0], root.key + prefixSum);
            return;
        }
        maxPath(root.left, prefixSum + root.key, max);
        maxPath(root.right, prefixSum + root.key, max);
    }
}
