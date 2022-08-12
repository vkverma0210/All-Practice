class Node {
    int val;
    Node left, right;

    Node(int x) {
        val = x;
    }
}

public class LowestCommonAncestorOfaBinarySearchTree {
    public static Node lowestCommonAncestor(Node root, Node p, Node q) {
        while (root != null) {
            if (root.val < p.val && root.val < q.val)
                root = root.right;
            else if (root.val > p.val && root.val > q.val)
                root = root.left;
            else
                break;
        }

        return root;
    }

    public static void main(String[] args) {
        Node tree = new Node(20);
        tree.left = new Node(8);
        tree.right = new Node(22);
        tree.left.left = new Node(4);
        tree.left.right = new Node(12);
        tree.left.right.left = new Node(10);
        tree.left.right.right = new Node(14);

        Node p = new Node(10);
        Node q = new Node(14);

        Node head = lowestCommonAncestor(tree, p, q);

        System.out.println(head.val);
    }
}
