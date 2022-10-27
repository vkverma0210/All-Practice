import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTreeLevelOrderTraversal {
    public static List<List<Integer>> levelOrder_Iterative(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int s = queue.size();

            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < s; i++) {
                TreeNode temp = queue.poll();
                list.add(temp.val);

                if (temp.left != null)
                    queue.add(temp.left);

                if (temp.right != null)
                    queue.add(temp.right);
            }

            res.add(list);
        }

        return res;
    }

    public static List<List<Integer>> levelOrder_Recursive(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        levelorderHelper(res, root, 0);
        return res;
    }

    public static void levelorderHelper(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null)
            return;

        if (height >= res.size()) {
            res.add(new LinkedList<>());
        }

        res.get(height).add(root.val);
        levelorderHelper(res, root.left, height + 1);
        levelorderHelper(res, root.right, height + 1);
    }

    public static void printList(List<List<Integer>> temp) {
        for (List<Integer> it : temp) {
            for (Integer et : it)
                System.out.print(et + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20);
        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(7);

        List<List<Integer>> ans1 = levelOrder_Iterative(tree);
        printList(ans1);

        List<List<Integer>> ans2 = levelOrder_Recursive(tree);
        printList(ans2);
    }
}
