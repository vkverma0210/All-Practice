class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class ValidateBinarySearchTree {
    public static boolean isValidBST(TreeNode root) {
        return bst(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public static boolean bst(TreeNode root, long minValue, long maxValue){
        if(root == null){
            return true;
        }

        if(root.val <= minValue || root.val >= maxValue)
           return false;
        
        return (bst(root.left, minValue, root.val) && bst(root.right, root.val, maxValue));
    }
    
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(1);
        tree.right = new TreeNode(4);
        tree.left.left = new TreeNode(3);
        tree.right.left = new TreeNode(1);
        tree.right.right = new TreeNode(5);

        System.out.println(isValidBST(tree));
    }
}
