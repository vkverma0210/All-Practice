import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class ReverseOddLevelsOfBinaryTree {
    public static TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) {
            return root;
        }

        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        int level = 0;

        while (!qu.isEmpty()) {
            int size = qu.size();

            while (size-- > 0) {
                TreeNode node = qu.poll();
                if (node.left != null) {
                    qu.offer(node.left);
                }

                if (node.right != null) {
                    qu.offer(node.right);
                }
            }

            level++;

            if (level % 2 == 1 && !qu.isEmpty()) {
                int nums[] = new int[qu.size()];
                int i = 0;

                for (TreeNode node : qu) {
                    nums[i++] = node.val;
                }

                int j = qu.size() - 1;

                for (TreeNode node : qu) {
                    node.val = nums[j--];
                }
            }
        }

        return root;
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
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(1);
        tree.right = new TreeNode(4);
        tree.left.left = new TreeNode(3);
        tree.left.right = new TreeNode(2);
        tree.right.left = new TreeNode(1);
        tree.right.right = new TreeNode(5);

        preorder(tree);
        TreeNode ans = reverseOddLevels(tree);
        System.out.println();
        preorder(ans);
    }
}
