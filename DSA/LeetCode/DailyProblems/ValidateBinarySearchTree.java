class TreeNode {
    long val;
    TreeNode left;
    TreeNode right;

    TreeNode(long val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class ValidateBinarySearchTree {
    static TreeNode node;

    public static boolean isValidBST(TreeNode root) {
        return bst(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean bst(TreeNode root, Long minValue, Long maxValue) {
        if (root == null) {
            return true;
        }

        if (root.val <= minValue || root.val >= maxValue)
            return false;

        return (bst(root.left, minValue, root.val) && bst(root.right, root.val, maxValue));
    }

    public static void preorder(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {

        ValidateBinarySearchTree tree = new ValidateBinarySearchTree();

        tree.node = new TreeNode(4);
        tree.node.left = new TreeNode(2);
        tree.node.right = new TreeNode(5);
        tree.node.left.left = new TreeNode(1);
        tree.node.left.right = new TreeNode(3);

        preorder(node);

        if (isValidBST(node))
            System.out.println("true");
        else
            System.out.println("false");
    }
}
