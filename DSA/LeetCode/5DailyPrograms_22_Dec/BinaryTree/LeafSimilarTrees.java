import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class LeafSimilarTrees {    
    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return false;

        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();
        dfs(root1, list1);
        dfs(root2, list2);

        if (list1.size() != list2.size())
            return false;
        else {
            for (int i = 0; i < list1.size(); i++)
                if (list1.get(i) != list2.get(i))
                    return false;
        }

        return true;
    }
    
    public static void dfs(TreeNode root, List<Integer> list) {
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }

        if (root.left != null) {
            dfs(root.left, list);
        }

        if (root.right != null) {
            dfs(root.right, list);
        }
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
        TreeNode tree1 = new TreeNode(3);
        tree1.left = new TreeNode(5);
        tree1.right = new TreeNode(1);
        tree1.left.left = new TreeNode(6);
        tree1.left.right = new TreeNode(2);
        tree1.right.left = new TreeNode(9);
        tree1.right.right = new TreeNode(8);
        tree1.left.right.left = new TreeNode(7);
        tree1.left.right.right = new TreeNode(4);

        System.out.println("Tree 1");
        preorder(tree1);
        System.out.println();

        TreeNode tree2 = new TreeNode(3);
        tree2.left = new TreeNode(5);
        tree2.right = new TreeNode(1);
        tree2.left.left = new TreeNode(6);
        tree2.left.right = new TreeNode(7);
        tree2.right.left = new TreeNode(4);
        tree2.right.right = new TreeNode(2);
        tree2.right.right.left = new TreeNode(9);
        tree2.right.right.right = new TreeNode(8);
       
        System.out.println("Tree 2");
        preorder(tree2);
        System.out.println();

        System.out.println(leafSimilar( tree1, tree2));
    }
}