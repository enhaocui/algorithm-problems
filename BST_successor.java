package Pocket_Gem;
import java.util.*;

/**
 * Created by xiaochen on 10/2/17.
 */
public class BST_successor {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode res = null;
        while (root != null) {
            if (root.val > p.val) {
                res = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return res;
    }

    public TreeNode inorderPre(TreeNode root, TreeNode p) {
        TreeNode res = null;
        while (root != null) {
            if (root.val < p.val) {
                res = root;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return res;
    }

    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode (int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }
}
