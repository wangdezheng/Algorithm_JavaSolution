package Tree;

/**
 * Given a binary tree in which each node contains an integer number. Find the maximum possible sum from any node to any node (the start node and the end node can be the same).

 Assumptions:

 ​  The root of the given binary tree is not null

 Examples:
                -1

              /    \

             2      11

                  /    \

                 6    -14

 one example of paths could be -14 -> 11 -> -1 -> 2

 another example could be the node 11 itself

 The maximum path sum in the above binary tree is 6 + 11 + (-1) + 2 = 18
 */
//Time: O(n), Space: O(height)
public class MaximumPathSumBinaryTreeII {
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] max = new int[] {Integer.MIN_VALUE};
        maxPathSum(root, max);
        return max[0];
    }

    private int maxPathSum(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int left = maxPathSum(root.left, max);
        int right = maxPathSum(root.right, max);
        left = left > 0 ? left : 0;
        right = right > 0 ? right : 0;
        max[0] = Math.max(max[0], left + right + root.key);
        return Math.max(left, right) + root.key;
    }
}
