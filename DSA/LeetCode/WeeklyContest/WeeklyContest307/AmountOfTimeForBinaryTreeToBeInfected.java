import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class AmountOfTimeForBinaryTreeToBeInfected {
    public static Map<Integer, List<Integer>> map = new HashMap<>();
    public static Set<Integer> visited = new HashSet<>();

    private static void traverse(Integer prev, TreeNode root) {
        if (root == null) {
            return;
        }

        int curr = root.val;

        if (prev != null) {
            List<Integer> list = map.getOrDefault(prev, new ArrayList<>());
            list.add(curr);
            map.put(prev, list);

            list = map.getOrDefault(curr, new ArrayList<>());
            list.add(prev);
            map.put(curr, list);
        }

        traverse(curr, root.left);
        traverse(curr, root.right);
    }

    public static int amountOfTime(TreeNode root, int start) {
        traverse(null, root);

        visited.add(start);

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        int ans = 0;

        while (q.size() > 0) {
            ans++;

            int n = q.size();

            for (int i = 0; i < n; i++) {
                int curr = q.poll();
                List<Integer> list = map.getOrDefault(curr, new ArrayList<>());

                for (int j = 0; j < list.size(); j++) {
                    if (visited.contains(list.get(j))) {
                        continue;
                    }

                    visited.add(list.get(j));
                    q.add(list.get(j));
                }
            }
        }

        return ans - 1;
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
        tree.left = new TreeNode(5);
        tree.right = new TreeNode(3);
        tree.left.right = new TreeNode(4);
        tree.right.left = new TreeNode(10);
        tree.right.right = new TreeNode(6);
        tree.left.right.left = new TreeNode(9);
        tree.left.right.right = new TreeNode(2);

        int start = 3;

        preorder(tree);
        System.out.println();

        System.out.println(amountOfTime(tree, start));
    }
}
