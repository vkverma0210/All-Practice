import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Vector;

public class N_aryTreeLevelOrderTraversal {
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

    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                temp.add(queue.peek().val);
                queue.addAll(queue.poll().children);
            }

            res.add(temp);
        }

        return res;
    }

    public static void printList(List<List<Integer>> temp) {
        for (List<Integer> it : temp) {
            for (Integer et : it)
                System.out.print(et + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Node root = newNode(1);
        (root.children).add(newNode(3));
        (root.children).add(newNode(2));
        (root.children).add(newNode(4));
        (root.children.get(0).children).add(newNode(5));
        (root.children.get(0).children).add(newNode(6));

        List<List<Integer>> ans = levelOrder(root);
        printList(ans);
    }
}
