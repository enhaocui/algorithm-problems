package Pocket_Gem;

/**
 * Created by xiaochen on 10/3/17.
 */
public class paserTenery {

    public static void main(String[] args) {
        String test = "a?b?d:e:c";
        TreeNode root = build(test);
        inorder(root);
    }

    // a?(b?d:e):(c)
    public static TreeNode build(String s) {
        if (s.length() == 0) return null;
        int index1 = s.indexOf('?'), index2 = s.lastIndexOf(':');
        char val = s.charAt(0);
        TreeNode root = new TreeNode(val);
        if (index1 == -1) return root;
        root.left = build(s.substring(index1 + 1, index2));
        root.right = build(s.substring(index2 + 1));
        return root;
    }

    public static void inorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        inorder(root.left);
        inorder(root.right);
    }

    static class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;
        public TreeNode(char val) {
            this.val = val;
        }
    }
}
