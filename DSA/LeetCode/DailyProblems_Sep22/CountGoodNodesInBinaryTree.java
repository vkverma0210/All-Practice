class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class CountGoodNodesInBinaryTree {
    public static int goodNodes(TreeNode root) {
        return countGoodNodes(root, Integer.MIN_VALUE);
    }

    private static int countGoodNodes(TreeNode root, int maxVal) {
        if (root == null)
            return 0;

        int res = root.val >= maxVal ? 1 : 0;

        res += countGoodNodes(root.left, Math.max(maxVal, root.val));
        res += countGoodNodes(root.right, Math.max(maxVal, root.val));

        return res;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(1);
        tree.right = new TreeNode(4);
        tree.left.left = new TreeNode(3);
        tree.right.left = new TreeNode(1);
        tree.right.right = new TreeNode(5);

        System.out.println(goodNodes(tree));
    }
}
