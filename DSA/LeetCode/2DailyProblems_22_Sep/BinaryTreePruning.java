class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTreePruning {
    public static void preorder(TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.print(node.val + " ");
        preorder(node.left);
        preorder(node.right);
    }

    public static TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        if (root.left != null || root.right != null) {
            return root;
        }

        if (root.val == 0)
            return null;

        return root;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(0);
        tree.right = new TreeNode(1);
        tree.left.left = new TreeNode(0);
        tree.left.right = new TreeNode(0);
        tree.right.left = new TreeNode(0);
        tree.right.right = new TreeNode(1);

        preorder(tree);
        System.out.println();

        TreeNode ans = pruneTree(tree);
        preorder(ans);
    }
}