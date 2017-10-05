package Pocket_Gem;

/**
 * Created by xiaochen on 10/3/17.
 */
public class LCABST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (p.val > q.val) return lowestCommonAncestor(root, q, p);

        if (root.val >= p.val && root.val <= q.val) return root;
        else if (root.val < p.val) return lowestCommonAncestor(root.right, p, q);
        else return lowestCommonAncestor(root.left, p, q);
    }


    public TreeNode lowestCommonAncestorBT(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;

        return left == null ? right : left;
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
