package Pocket_Gem;

/**
 * Created by xiaochen on 10/3/17.
 */
public class serializeDePre {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }
    public void buildString(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null").append(",");
        } else {
            sb.append(root.val).append(",");
            buildString(root.left, sb);
            buildString(root.right, sb);
        }
    }
    // {4,1,null,5,null,null,3,7,8,null,null,null,null}
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        String[] vals = data.split(",");
        int[] pointer = new int[1];
        return buildTree(vals, pointer);
    }
    public TreeNode buildTree(String[] vals, int[] pointer) {
        if (pointer[0] >= vals.length) return null;
        if (vals[pointer[0]].equals("null")) {
            pointer[0]++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(vals[pointer[0]]));
        pointer[0]++;
        root.left = buildTree(vals, pointer);
        root.right = buildTree(vals, pointer);
        return root;
    }

    //{4,1,3,null,5,7,null,null,null,8}
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
