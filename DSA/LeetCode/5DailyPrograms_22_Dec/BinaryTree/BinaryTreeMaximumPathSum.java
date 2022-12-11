class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int val) {
		this.val = val;
	}
}

public class BinaryTreeMaximumPathSum {
    private static int maxVal = Integer.MIN_VALUE;
    
    public static int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        maxBranchSum(root);
        return maxVal;
    }
    
    public static int maxBranchSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftB = maxBranchSum(root.left);
        int rightB = maxBranchSum(root.right);

        int maxB = root.val + Math.max(leftB, rightB);
        maxB = Math.max(root.val, maxB);

        int maxPath = Math.max(maxB, root.val + leftB + rightB);
        maxVal = Math.max(maxVal, maxPath);
        return maxB;
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

		System.out.println(maxPathSum(tree1));
	}   
}
