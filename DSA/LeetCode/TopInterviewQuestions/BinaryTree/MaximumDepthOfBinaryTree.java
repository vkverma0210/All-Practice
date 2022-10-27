class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class MaximumDepthOfBinaryTree {
    public static int maxDepth(TreeNode root) {
        // Base Condition
        if (root == null)
            return 0;

        // Hypothesis
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        // Induction
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(1);
        tree.right = new TreeNode(4);
        tree.left.left = new TreeNode(3);
        tree.right.left = new TreeNode(1);
        tree.right.right = new TreeNode(5);

        System.out.println(maxDepth(tree));
    }
}
