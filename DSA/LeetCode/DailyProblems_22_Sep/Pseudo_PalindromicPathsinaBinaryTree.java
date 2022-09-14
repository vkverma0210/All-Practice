class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Pseudo_PalindromicPathsinaBinaryTree {
    static int count = 0;

    public static int pseudoPalindromicPaths(TreeNode root) {
        int[] temp = new int[10];

        pseudo_count(root, temp);

        return count;
    }

    private static void pseudo_count(TreeNode root, int[] temp) {
        if (root == null)
            return;

        temp[root.val]++;
        pseudo_count(root.left, temp);
        pseudo_count(root.right, temp);

        if (root.left == null && root.right == null) {
            int flag = 0;

            for (int i = 1; i <= 9; i++) {
                if (temp[i] % 2 != 0)
                    flag++;
            }

            if (flag == 1 || flag == 0)
                count++;
        }

        temp[root.val]--;
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
        TreeNode tree = new TreeNode(2);
        tree.left = new TreeNode(3);
        tree.right = new TreeNode(1);
        tree.left.left = new TreeNode(3);
        tree.left.right = new TreeNode(1);
        tree.right.right = new TreeNode(1);

        preorder(tree);
        System.out.println();

        System.out.println(pseudoPalindromicPaths(tree));
    }
}
