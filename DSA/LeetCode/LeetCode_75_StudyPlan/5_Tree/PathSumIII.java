import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class PathSumIII {
    private static int pathSum_helper(TreeNode root, int targetSum, long sum) {
        if (root == null) {
            return 0;
        }

        int res = 0;

        sum += root.val;

        if (sum == targetSum) {
            res++;
        }

        res += pathSum_helper(root.left, targetSum, sum);
        res += pathSum_helper(root.right, targetSum, sum);

        sum -= root.val;

        return res;
    }

    public static int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        return pathSum(root.left, targetSum) + pathSum_helper(root, targetSum, 0) + pathSum(root.right, targetSum);
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
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(7);

        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();

        System.out.println("Given Binary Tree: ");
        preorder(tree);
        System.out.println();
        System.out.println(pathSum(tree, n));

        scr.close();
    }
}
