import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTreeRightSideView {
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        rightSideView_Helper(root, res, 0);
        return res;
    }

    public static void rightSideView_Helper(TreeNode root, List<Integer> res, int currDepth) {
        if (root == null) {
            return;
        }

        if (currDepth == res.size()) {
            res.add(root.val);
        }

        rightSideView_Helper(root.right, res, currDepth + 1);
        rightSideView_Helper(root.left, res, currDepth + 1);
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

        System.out.println("Given Binary Tree: ");
        preorder(tree);
        System.out.println();
        List<Integer> ans = rightSideView(tree);
        System.out.println(ans);
    }
}
