import java.util.Stack;
import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class KthSmallestElementInABST {
    public static int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        while (k != 0) {
            TreeNode temp = stack.pop();
            k--;

            if (k == 0) {
                return temp.val;
            }

            TreeNode right = temp.right;

            while (right != null) {
                stack.push(right);
                right = right.left;
            }
        }

        return -1;
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
        TreeNode tree = new TreeNode(5);
        tree.left = new TreeNode(3);
        tree.right = new TreeNode(6);
        tree.left.left = new TreeNode(2);
        tree.left.right = new TreeNode(4);
        tree.left.left.left = new TreeNode(1);

        Scanner scr = new Scanner(System.in);
        int k = scr.nextInt();

        System.out.println("Given Binary Tree: ");
        preorder(tree);
        System.out.println();

        System.out.println(kthSmallest(tree, k));
        scr.close();

    }
}
