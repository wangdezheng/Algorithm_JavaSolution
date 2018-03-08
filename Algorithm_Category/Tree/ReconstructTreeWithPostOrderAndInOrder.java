package Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Reconstruct a tree (with no duplicate values) with post-order and in-order sequences of all nodes.
 *
 *  Examples:
                10

             /     \

           5       15

        /    \   /    \

       2     7  12    20

 index       0  1  2  3 | 4  5  6
 Post-order  2  7  5 | 12 20 15 10
 In-order    2  5  7  10| 12 15 20
 */

//Time: O(n), Space: O(n)
public class ReconstructTreeWithPostOrderAndInOrder {
    public TreeNode reconstruct(int[] in, int[] post) {
        if (in == null || post == null) {
            return null;
        }
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            inOrderMap.put(in[i], i);
        }
        return reconstruct(in, 0, in.length - 1, post, 0, post.length - 1, inOrderMap);
    }

    private TreeNode reconstruct(int[] in, int inLeft, int inRight, int[] post, int postLeft, int postRight, Map<Integer, Integer> inOrderMap) {
        if (inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(post[postRight]);
        int leftSize = inOrderMap.get(root.key) - inLeft;
        root.left = reconstruct(in, inLeft, inLeft + leftSize - 1, post, postLeft, postLeft + leftSize - 1, inOrderMap);
        root.right = reconstruct(in, inLeft + leftSize + 1, inRight, post, postLeft + leftSize, postRight - 1, inOrderMap);
        return root;
    }
}
