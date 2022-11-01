import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class PathSumII {
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        int sum = 0;
        TreeNode curr = root;
        TreeNode pre = null;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                path.add(curr.val);
                sum += curr.val;
                curr = curr.left;
            }

            curr = stack.peek();

            if (curr.right != null && curr.right != pre) {
                curr = curr.right;
                continue;
            }

            if (curr.left == null && curr.right == null && sum == targetSum) {
                res.add(new ArrayList<>(path));
            }

            pre = curr;
            stack.pop();
            path.remove(path.size() - 1);
            sum -= curr.val;
            curr = null;
        }

        return res;
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
        tree.left = new TreeNode(4);
        tree.right = new TreeNode(8);
        tree.left.left = new TreeNode(11);
        tree.right.left = new TreeNode(13);
        tree.right.right = new TreeNode(4);
        tree.left.left.left = new TreeNode(7);
        tree.left.left.right = new TreeNode(2);
        tree.right.right.left = new TreeNode(5);
        tree.right.right.right = new TreeNode(1);

        Scanner scr = new Scanner(System.in);
        int targetSum = scr.nextInt();

        System.out.println("Given Binary Tree: ");
        preorder(tree);
        System.out.println();

        System.out.println(pathSum(tree, targetSum));

        scr.close();

    }
}
