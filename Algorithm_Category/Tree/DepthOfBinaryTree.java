package Tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 Find the Depth of binary tree.

 Examples:
            5
          /    \
        3        8
      /   \        \
    1      4        11

 The height of above binary tree is 3.
 */

//Time: O(n), Space: O(Height)
public class DepthOfBinaryTree {
  public int findDepth(TreeNode root) {
    int result = 0;
    Deque<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (root != null && !queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        root = queue.poll();
        if (root.left != null) {
          queue.offer(root.left);
        }
        if (root.right != null) {
          queue.offer(root.right);
        }
      }
      result++;
    }
    return result;
  }

//  public int findDepth(TreeNode root) {
//     return findDepth(root, 0);
//  }
//
//  private int findDepth(TreeNode root, int depth) {
//    if (root == null) {
//      return 0;
//    }
//    int leftDepth = findDepth(root.left, depth);
//    int rightDepth = findDepth(root.right, depth);
//    return Math.max(leftDepth, rightDepth) + 1;
//  }
}
