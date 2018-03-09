package Tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Construct a tree from in-order and level-order traversals of binary tree.
 *
 * Assumptions:
        The given sequences are not null and they have the same length
        There are no duplicate keys in the binary tree
 *
 *  Examples:
            20

         /     \

       8       22

    /    \

   4     12

       /    \

     10     14

 index        0  1  2  3 | 4  5  6
 Level-order  20 8 22 4 12 10 14
 In-order     4 8 10 12 14 20 | 22
 *
 */

//Step1: for each function, build the HashSet for left subtree elements in in-order array.
//Step2: iterate over level-order one by one,
    //foe each current element x,
    //case1: hashSet contains x, x belongs to the left subtree,  put x into new left level-order array
    //case2: doesn't contain x, x belongs to the right subtree, put x into new right level-order array
//Step3: recursion

//Time: O(n ^ 2), Space: O(n ^ 2)
public class ReconstructTreeWithLevelOrderAndInOrder {
    public TreeNode rebuildTree(int[] in, int[] level) {
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            inOrderMap.put(in[i], i);
        }
        return rebuildTree(in, 0, in.length - 1, level, inOrderMap);
    }

    private TreeNode rebuildTree(int[] in, int inLeft, int inRight, int[] level, Map<Integer, Integer> inOrderMap) {
        if (inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(level[0]);
        int rootIndex = inOrderMap.get(level[0]);
        Set<Integer> leftSet = new HashSet<>();
        for (int i = inLeft; i < rootIndex; i++) {
            leftSet.add(in[i]);
        }
        int[] levelLeft = new int[rootIndex - inLeft];
        int[] levelRight = new int[inRight - rootIndex];
        int left = 0;
        int right = 0;
        for (int i = 1; i < level.length; i++) {
            if (leftSet.contains(level[i])) {
                levelLeft[left++] = level[i];
            } else {
                levelRight[right++] = level[i];
            }
        }
        root.left = rebuildTree(in, inLeft, rootIndex - 1, levelLeft, inOrderMap);
        root.right = rebuildTree(in, rootIndex + 1, inRight, levelRight, inOrderMap);
        return root;
    }
}
