class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int val) {
		this.val = val;
	}
}

public class MaximumProductOfSplittedBinaryTree {
    private static long max = 0;
    
    public static int maxProduct(TreeNode root) {
        if (root == null) {
            return 0;
        }

        max = root.val;
        long total = sum(root);
        dfs(root, total);
        return (int) (max % (Math.pow(10, 9) + 7));
    }

    private static long dfs(TreeNode root, long total) {
        if (root == null) {
            return 0;
        }

        long left = dfs(root.left, total);
        long right = dfs(root.right, total);
        long rem = total - left;
        max = Math.max(max, rem * left);
        rem = total - right;
        max = Math.max(max, rem * right);
        return left + right + root.val;
    }
    
    private static long sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        long left = sum(root.left);
        long right = sum(root.right);
        return left + right + root.val; 
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
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(3);
        tree1.left.left = new TreeNode(4);
        tree1.left.right = new TreeNode(5);
        tree1.right.left = new TreeNode(6);

        System.out.println("Tree 1");
        preorder(tree1);
        System.out.println();

        System.out.println(maxProduct(tree1));
    }
}
