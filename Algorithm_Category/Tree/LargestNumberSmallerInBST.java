package Tree;

/**
 In a binary search tree, find the node containing the largest number smaller than the given target number. If there is no such number, return INT_MIN.
 Assumptions:
    The given root is not null.
    There are no duplicate keys in the binary search tree.

 Examples:
                5

            /    \

          2      11

               /    \

              6     14

 largest number smaller than 1 is Integer.MIN_VALUE(Java) or INT_MIN(c++)
 largest number smaller than 10 is 6
 largest number smaller than 6 is 5
 */
//Time: O(n), Space: O(1)
public class LargestNumberSmallerInBST {
    public int largestSmaller(TreeNode root, int target) {
        int min = Integer.MAX_VALUE;
        while (root != null) {
            if (root.key >= target) {
                root = root.left;
            } else {
                min = Math.min(min, target - root.key);
                root = root.right;
            }
        }
        return min == Integer.MAX_VALUE ? Integer.MIN_VALUE : target - min;
    }
}
