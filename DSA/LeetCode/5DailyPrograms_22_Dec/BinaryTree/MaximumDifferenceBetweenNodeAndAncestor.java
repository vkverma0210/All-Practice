class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int val) {
		this.val = val;
	}
}

public class MaximumDifferenceBetweenNodeAndAncestor {
    public static int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    public static int dfs(TreeNode root, int minValue, int maxValue) {
        if (root == null) {
            return 0;
        }

        int op1 = Math.max(Math.abs(root.val - minValue), Math.abs(root.val - maxValue));

        if (root.val < minValue) {
            minValue = root.val;
        }

        if (root.val > maxValue) {
            maxValue = root.val;
        }
        
        int op2 = Math.max(dfs(root.left, minValue, maxValue), dfs(root.right, minValue, maxValue));

        return Math.max(op1, op2);
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
        TreeNode tree1 = new TreeNode(8);
        tree1.left = new TreeNode(3);
        tree1.right = new TreeNode(10);
        tree1.left.left = new TreeNode(1);
        tree1.left.right = new TreeNode(6);
        tree1.right.right = new TreeNode(14);
        tree1.left.right.left = new TreeNode(4);
        tree1.left.right.right = new TreeNode(7);
        tree1.right.right.left = new TreeNode(13);

        System.out.println("Tree 1");
        preorder(tree1);
        System.out.println();

        System.out.println(maxAncestorDiff(tree1));
    }
}