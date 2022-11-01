import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class AddOneRowToTree {
    public static TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 0 || depth == 1) {
            TreeNode newroot = new TreeNode(val);
            newroot.left = depth == 1 ? root : null;
            newroot.right = depth == 0 ? root : null;
            return newroot;
        }

        if (root != null && depth >= 2) {
            root.left = addOneRow(root.left, val, depth > 2 ? depth - 1 : 1);
            root.right = addOneRow(root.right, val, depth > 2 ? depth - 1 : 0);
        }

        return root;
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
        TreeNode tree = new TreeNode(5);
        tree.left = new TreeNode(4);
        tree.right = new TreeNode(8);
        tree.left.left = new TreeNode(11);
        tree.right.left = new TreeNode(13);
        tree.right.right = new TreeNode(4);
        tree.left.left.left = new TreeNode(7);
        tree.left.left.right = new TreeNode(2);
        tree.right.right.right = new TreeNode(1);

        Scanner scr = new Scanner(System.in);
        int val = scr.nextInt();
        int depth = scr.nextInt();

        preorder(tree);
        System.out.println();

        System.out.println(addOneRow(tree, val, depth));

        scr.close();
    }
}
