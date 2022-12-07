class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class RangeSumOfBST {
    public static int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        if (root.val >= low && root.val <= high) {
            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        } else if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        } else {
            return rangeSumBST(root.left, low, high);
        }
    }

    public static void preorder(TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.print(node.val + " ");
        preorder(node.left);
        preorder(node.right);
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(10);
        tree.left = new TreeNode(5);
        tree.right = new TreeNode(15);
        tree.left.left = new TreeNode(3);
        tree.left.right = new TreeNode(7);
        tree.right.right = new TreeNode(18);

        preorder(tree);
        System.out.println();

        System.out.println(rangeSumBST(tree, 7, 15));
    }
}