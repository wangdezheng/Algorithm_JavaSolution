package Tree;

/**
 * Given a binary tree in which each node contains an integer number. Find the maximum possible sum from any node
 * to any node (the two nodes can be the same node and they can only be the path from root to one of the leaf nodes).

 Assumptions:

 ​  The root of the given binary tree is not null

 Examples:
            -5

         /    \

       2      11

            /    \

           6    -14

 The maximum path sum is 11 + 14 = 25
 */
//Time: O(n), Space: O(Height), bottom-up solution
public class MaximumPathSumBinaryTreeIII {
    public int maxPathSum(TreeNode root) {
        int[] max = new int[]{Integer.MIN_VALUE};
        maxPathSum(root, max);
        return max[0];
    }

    private int maxPathSum(TreeNode root, int[] max) {
        if(root == null) {
            return 0;
        }
        int leftSum = maxPathSum(root.left, max);
        int rightSum = maxPathSum(root.right, max);
        int tmp = Math.max(0, Math.max(leftSum, rightSum));
        max[0] = Math.max(max[0], root.key + tmp);
        return root.key + tmp;
    }
}

//Time: O(n), Space: O(1), DP solution, pre-order traversal;
//public class MaximumPathSumBinaryTreeIII {
//    public int maxPathSum(TreeNode root) {
//        int[] max = new int[]{Integer.MIN_VALUE};
//        maxPathSum(root, max, 0);
//        return max[0];
//    }
//
//    private void maxPathSum(TreeNode root, int[] max, int sum) {
//        if(root == null) {
//            return;
//        }
//        if (sum < 0) {
//            sum = root.key;
//        } else {
//            sum += root.key;
//        }
//        max[0] = Math.max(max[0], sum);
//        maxPathSum(root.left, max, sum);
//        maxPathSum(root.right, max, sum);
//    }
//}


