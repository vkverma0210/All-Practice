import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTreeInorderTraversal {
    public static List<Integer> inorderTraversal_Iterative(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();

        TreeNode curr = root;

        while (curr != null || !st.isEmpty()) {
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }

            curr = st.pop();
            ans.add(curr.val);
            curr = curr.right;
        }

        return ans;
    }

    public static List<Integer> inorderTraversal_Recursive(TreeNode root) {
        List<Integer> ls = new ArrayList<>();

        inorderTraversalHelper(root, ls);

        return ls;
    }

    private static void inorderTraversalHelper(TreeNode root, List<Integer> ls) {
        if (root == null)
            return;

        inorderTraversalHelper(root.left, ls);
        ls.add(root.val);
        inorderTraversalHelper(root.right, ls);
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(1);
        tree.right = new TreeNode(4);
        tree.left.left = new TreeNode(3);
        tree.right.left = new TreeNode(1);
        tree.right.right = new TreeNode(5);

        System.out.println(inorderTraversal_Recursive(tree));
        System.out.println(inorderTraversal_Iterative(tree));
    }
}
