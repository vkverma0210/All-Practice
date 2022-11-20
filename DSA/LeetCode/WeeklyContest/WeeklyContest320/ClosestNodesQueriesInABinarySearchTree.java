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

public class ClosestNodesQueriesInABinarySearchTree {
    public static void inOrder(TreeNode root, List<Integer> dp) {
        if (root == null) {
            return;
        }

        inOrder(root.left, dp);
        dp.add(root.val);
        inOrder(root.right, dp);
    }

    private static int findmin(List<Integer> dp, int q) {
        int ans = -1;
        int start = 0;
        int end = dp.size() - 1;

        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (dp.get(mid) <= q) {
                ans = dp.get(mid);
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }

    private static int findmax(List<Integer> dp, int q) {
        int ans = -1;
        int start = 0;
        int end = dp.size() - 1;

        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (dp.get(mid) >= q) {
                ans = dp.get(mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }

    public static List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> ans = new ArrayList<>();
        int mini = -1, maxi = -1;
        List<Integer> dp = new ArrayList<>();
        inOrder(root, dp);
        int i = 0;
        for (Integer q : queries) {
            mini = findmin(dp, q);
            maxi = findmax(dp, q);

            List<Integer> temp = new ArrayList<>();
            temp.add(mini);
            temp.add(maxi);
            ans.add(temp);

            mini = -1;
            maxi = -1;
        }

        return ans;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(6);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(13);
        tree.left.left = new TreeNode(1);
        tree.left.right = new TreeNode(4);
        tree.right.left = new TreeNode(9);
        tree.right.right = new TreeNode(15);
        tree.right.right.left = new TreeNode(14);

        List<Integer> queries = new ArrayList<>();
        queries.add(2);
        queries.add(5);
        queries.add(16);

        List<List<Integer>> ans = closestNodes(tree, queries);

        System.out.println(ans);
    }
}
