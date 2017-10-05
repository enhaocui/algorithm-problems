package Pocket_Gem;

/**
 * Created by xiaochen on 10/2/17.
 */
public class maxPathsum {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        find(root);
        return max;
    }
    public int find(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(find(root.left), 0);
        int right = Math.max(find(root.right), 0);
        max = Math.max(max, root.val + left + right);
        return Math.max(left, right) + root.val;
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
