package Tree;

/**
 * Given a binary tree in which each node contains an integer number. Find the maximum possible sum from one leaf node to another leaf node.
 Examples:
       -15

     /    \

    2     11

        /     \

       6       14
 The maximum path sum is 6 + 11 + 14 = 31.
 */
//Time: O(n), Space: O(Height)
public class MaximumPathSumBinaryTreeI {
    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        pathSum(root, max);
        return max[0];
    }

    private int pathSum(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int left = pathSum(root.left, max);
        int right = pathSum(root.right, max);
        if (root.left != null && root.right != null) {
            max[0] = Math.max(max[0], left + right + root.key);
            return root.key + Math.max(left, right);
        }
        return root.left == null ? right + root.key : left + root.key;
    }
}
