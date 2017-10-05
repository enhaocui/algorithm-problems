package Pocket_Gem;

/**
 * Created by xiaochen on 10/3/17.
 */
public class ConstructStringFromBT {
    public String tree2str(TreeNode t) {
        if (t == null) return "";
        if (t.left == null && t.right == null) return String.valueOf(t.val);
        String cur = t.val + "(" + tree2str(t.left) + ")";
        if (t.right != null) cur += "(" + tree2str(t.right) + ")";
        return cur;
    }


    public TreeNode str2tree(String s) {
        if (s.length() == 0) return null;
        int index = s.indexOf('(');
        int val = index == -1 ? Integer.valueOf(s) : Integer.valueOf(s.substring(0, index));

        TreeNode root = new TreeNode(val);
        if (index == -1) return root;

        int start = index, count = 0;
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) == '(') count++;
            if (s.charAt(i) == ')') count--;

            if (count == 0 && start == index) {
                root.left = str2tree(s.substring(start + 1, i));
                start = i + 1;
            } else if (count == 0) {
                root.right = str2tree(s.substring(start + 1, i));
            }
        }
        return root;
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
