package Tree;

//Time: O(Height), Space: O(1)
public class SearchInBST {
    public TreeNode search(TreeNode root, int key) {
//        TreeNode cur = root;   //Iterative way
//        while (cur != null && cur.key != key) {
//            cur = cur.key > key ? cur.left : cur.right;
//        }
//        return cur;
        if (root == null || root.key == key) {  //recursion way
            return root;
        }
        if (root.key > key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }
}
