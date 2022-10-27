class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class LowestCommonAncestorofaBinarySearchTree {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val < p.val && root.val < q.val)
                root = root.right;
            else if (root.val > p.val && root.val > q.val)
                root = root.left;
            else
                break;
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(20);
        tree.left = new TreeNode(8);
        tree.right = new TreeNode(22);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(12);
        tree.left.right.left = new TreeNode(10);
        tree.left.right.right = new TreeNode(14);

        TreeNode p = new TreeNode(10);
        TreeNode q = new TreeNode(14);

        TreeNode head = lowestCommonAncestor(tree, p, q);

        System.out.println(head.val);
    }
}
