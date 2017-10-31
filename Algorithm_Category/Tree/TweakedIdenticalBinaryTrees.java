package Tree;

/**
 * Determine whether two given binary trees are identical assuming any number of ‘tweak’s are allowed. A tweak is defined as a swap of the children of one node in the tree.
 */

//Time: O(n^2), Space: O(Height)
//Assume the original tree is balanced, therefore there are log_2(n) levels in the tree;
//Time = 4 ^ (log n) = 2 ^ (2 * log n) = 2 ^ log (n^2) = n^2;
public class TweakedIdenticalBinaryTrees {
    public boolean isTweakedIdentical(TreeNode one, TreeNode two) {
        if (one == null || two == null) {
            return one == null && two == null;
        } else if (one.key != two.key) {
            return false;
        }
        return (isTweakedIdentical(one.left, two.right) && isTweakedIdentical(one.right, two.left))
                || (isTweakedIdentical(one.left, two.left) && isTweakedIdentical(one.right, two.right));
    }
}
