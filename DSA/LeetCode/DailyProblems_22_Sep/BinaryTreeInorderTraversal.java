import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

class TreeNode{
    int val;    
    TreeNode left,right;
    
    TreeNode(int val){
        this.val = val;
    }
}

public class BinaryTreeInorderTraversal {
    public static void inorderTraversalHelper(TreeNode root, List<Integer> list)
        {
            if (root == null) {
                return;
            }

            inorderTraversalHelper(root.left, list);
            list.add(root.val);
            inorderTraversalHelper(root.right, list);
        }
    

    public static List<Integer> inorderTraversal_Recursive(TreeNode root){
        List<Integer> list = new ArrayList<>();
        inorderTraversalHelper(root, list);
        return list;
    }

    public static List<Integer> inorderTraversal_Iterative(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        
        TreeNode curr = root;

        while(curr != null || !st.isEmpty()){
            while(curr != null){
                st.push(curr);
                curr = curr.left;
            }
            
            curr = st.pop();
            list.add(curr.val);
            curr = curr.right;
        }

        return list;
    }
    
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(1);
        tree.right = new TreeNode(4);
        tree.left.left = new TreeNode(3);
        tree.right.left = new TreeNode(1);
        tree.right.right = new TreeNode(5);

        System.out.println(inorderTraversal_Recursive(tree));
        System.out.println(inorderTraversal_Iterative(tree));
    }
}
