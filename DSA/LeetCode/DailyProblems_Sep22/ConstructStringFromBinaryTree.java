class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class ConstructStringFromBinaryTree {
    public static String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }

        String result = root.val + "";

        String left = tree2str(root.left);
        String right = tree2str(root.right);

        if (left == "" && right == "")
            return result;

        if (left == "")
            return result + "()" + "(" + right + ")";

        if (right == "")
            return result + "(" + left + ")";

        return result + "(" + left + ")" + "(" + right + ")";
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(1);
        tree.right = new TreeNode(4);
        tree.left.left = new TreeNode(3);
        tree.right.left = new TreeNode(1);
        tree.right.right = new TreeNode(5);

        System.out.println(tree2str(tree));
    }
}
