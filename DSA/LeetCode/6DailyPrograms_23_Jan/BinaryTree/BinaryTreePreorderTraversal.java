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

public class BinaryTreePreorderTraversal {
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorderTraversalHelper(root, res);
        return res;
    }

    public static void preorderTraversalHelper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        res.add(root.val);
        preorderTraversalHelper(root.left, res);
        preorderTraversalHelper(root.right, res);
    }

    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(3);
        tree1.left.left = new TreeNode(4);
        tree1.left.right = new TreeNode(5);
        tree1.right.left = new TreeNode(6);
        List<Integer> ans = preorderTraversal(tree1);

        System.out.println(ans);
    }
}
