import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

import javax.naming.spi.DirStateFactory.Result;

public class N_aryTreePreorderTraversal {
    static class Node {
        public int val;
        public Vector<Node> children;

        public Node(int _val) {
            val = _val;
            children = new Vector<Node>();
        }
    }

    static Node newNode(int key) {
        Node temp = new Node(key);
        return temp;
    }

    public static List<Integer> preorder_Iterative(Node root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Stack<Node> stack = new Stack<>();

        stack.add(root);

        while (!stack.isEmpty()) {
            Node temp = stack.pop();
            res.add(temp.val);

            for (int i = temp.children.size() - 1; i >= 0; i--) {
                stack.add(temp.children.get(i));
            }
        }

        return res;
    }

    public static List<Integer> result = new ArrayList<>();

    public static List<Integer> preorder_Recursive(Node root) {
        if (root == null) {
            return result;
        }

        result.add(root.val);

        for (Node node : root.children) {
            preorder_Recursive(node);
        }

        return result;
    }

    public static void main(String[] args) {
        Node root = newNode(1);
        (root.children).add(newNode(3));
        (root.children).add(newNode(2));
        (root.children).add(newNode(4));
        (root.children.get(0).children).add(newNode(5));
        (root.children.get(0).children).add(newNode(6));

        List<Integer> ans1 = preorder_Iterative(root);
        for (Integer ls : ans1) {
            System.out.print(ls + " ");
        }

        System.out.println();

        List<Integer> ans2 = preorder_Recursive(root);
        for (Integer ls : ans2) {
            System.out.print(ls + " ");
        }

        System.out.println();
    }
}
