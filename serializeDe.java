package Pocket_Gem;
import java.util.*;

/**
 * Created by xiaochen on 10/3/17.
 */
public class serializeDe {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                sb.append("null").append(",");
                continue;
            }
            sb.append(cur.val).append(",");
            queue.add(cur.left);
            queue.add(cur.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;

        String[] val = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(val[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for (int i = 1; i < val.length - 1; i++) {
            TreeNode parent = queue.poll();
            if (!val[i].equals("null")) {
                parent.left = new TreeNode(Integer.valueOf(val[i]));
                queue.add(parent.left);
            }
            if (!val[++i].equals("null")) {
                parent.right = new TreeNode(Integer.valueOf(val[i]));
                queue.add(parent.right);
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
