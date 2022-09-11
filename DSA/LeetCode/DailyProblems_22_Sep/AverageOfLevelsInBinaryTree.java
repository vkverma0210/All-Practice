import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {
    public static List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Double> ans = new ArrayList<>();

        if (root == null)
            return ans;

        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();
            Double sum = 0.0D;

            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();

                if (node.left != null)
                    q.add(node.left);

                if (node.right != null)
                    q.add(node.right);

                sum += node.val;
            }

            ans.add(sum / n);
        }

        return ans;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(1);
        tree.right = new TreeNode(4);
        tree.left.left = new TreeNode(3);
        tree.right.left = new TreeNode(1);
        tree.right.right = new TreeNode(5);

        System.out.println(averageOfLevels(tree));
    }
}
