class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class SameTree_2 {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }

        return false;
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
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(0);
        tree1.right = new TreeNode(1);
        tree1.left.left = new TreeNode(0);
        tree1.left.right = new TreeNode(0);
        tree1.right.left = new TreeNode(0);
        tree1.right.right = new TreeNode(1);

        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(0);
        tree2.right = new TreeNode(1);
        tree2.left.left = new TreeNode(0);
        tree2.left.right = new TreeNode(0);
        tree2.right.left = new TreeNode(0);
        tree2.right.right = new TreeNode(1);

        System.out.println("Tree1");
        preorder(tree1);
        System.out.println();

        System.out.println("Tree2");
        preorder(tree2);
        System.out.println();

        System.out.println(isSameTree(tree1, tree2));
    }
}
