import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class TwoSumIV_InputisaBST {
    // 1. Using HashTable
    public static boolean findTarget1(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return findTarget1_Helper(root, k, set);
    }

    private static boolean findTarget1_Helper(TreeNode root, int k, HashSet<Integer> set) {
        if (root == null) {
            return false;
        }

        if (set.contains(k - root.val)) {
            return true;
        }

        set.add(root.val);
        return findTarget1_Helper(root.left, k, set) || findTarget1_Helper(root.right, k, set);
    }

    // 2. Using array and use 2 pointer
    public static boolean findTarget(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);
        int i = 0, j = nums.size() - 1;
        while (i < j) {
            if (nums.get(i) + nums.get(j) == k) {
                return true;
            } else if (nums.get(i) + nums.get(j) < k) {
                i++;
            } else {
                j--;
            }
        }

        return false;
    }

    private static void inorder(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return;
        }
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
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
        tree.left = new TreeNode(3);
        tree.right = new TreeNode(6);
        tree.left.left = new TreeNode(2);
        tree.left.right = new TreeNode(4);
        tree.right.right = new TreeNode(7);

        Scanner scr = new Scanner(System.in);
        int k = scr.nextInt();

        preorder(tree);
        System.out.println();

        System.out.println(findTarget1(tree, k));
        System.out.println(findTarget(tree, k));

        scr.close();
    }
}
