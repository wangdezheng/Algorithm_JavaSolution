package Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Reconstruct a tree (with no duplicate values) with pre-order and in-order sequences of all nodes.
 *
 * Assumptions:

        The given sequences are not null and they have the same length
        There are no duplicate keys in the binary tree
 *
 *  Examples:
                10

             /     \

           5       15

        /    \   /    \

       2     7  12    20

 index       0  1  2  3 | 4  5  6
 Pre-order  10  5  2  7 | 15 12 20
 In-order    2  5  7  10| 12 15 20
  */

//Time: O(n), Space: O(n)
public class ReconstructTreeWithPreOrderAndInOrder {
    public TreeNode reconstruct(int[] in, int[] pre) {
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            inOrderMap.put(in[i], i);
        }
        return reconstruct(in, 0, in.length - 1, pre, 0, pre.length - 1, inOrderMap);
    }

    private TreeNode reconstruct(int[] in, int inLeft, int inRight, int[] pre, int preLeft, int preRight, Map<Integer, Integer> inOrderMap) {
        if (inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preLeft]);
        int leftSize = inOrderMap.get(root.key) - inLeft;
        root.left = reconstruct(in, inLeft, inLeft + leftSize - 1, pre, preLeft + 1, preLeft + leftSize, inOrderMap);
        root.right = reconstruct(in, inLeft + leftSize + 1, inRight, pre, preLeft + leftSize + 1, preRight, inOrderMap);
        return root;
    }
}
