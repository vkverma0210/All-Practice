import java.util.TreeMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

class Node {
    // Use a treeMap to maintain the insertion order
    TreeMap<String, Node> children;
    boolean endOfWord;

    Node() {
        children = new TreeMap<>();
        endOfWord = false;
    }
}

public class FileDirectory {
    Node root;

    public void mkdir(String word) {
        // /root/user/vinay
        String[] dir = word.split("/");
        Node curr = this.root;

        for (int i = 1; i < dir.length; i++) {
            String ch = dir[i];
            System.out.print(ch + " ");
            if (curr.children.get(ch) == null) {
                curr.children.put(ch, new Node());
            }

            curr = curr.children.get(ch);
        }

        curr.endOfWord = true;
    }

    // public String[] ls(String word) {
    // Node curr = this.root;

    // if (curr == null) {
    // return new String[0];
    // }

    // Queue<Node> queue = new LinkedList<>();

    // queue.add(root);

    // while (!queue.isEmpty()) {
    // int size = queue.size();

    // if (queue.peek().toString() == word) {
    // Node temp = queue.poll();
    // queue.clear();
    // queue.addAll(temp.children);

    // int size1 = queue.size();

    // String[] result = new String[size1];
    // for (int i = 0; i < size1; i++) {
    // result[i] = queue.poll().toString();
    // }

    // return result;
    // }
    // queue.poll();
    // }

    // return new String[0];
    // }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        FileDirectory file = new FileDirectory();
        file.root = new Node();

        int n = scr.nextInt();
        for (int i = 0; i < n; i++) {
            String words = scr.next();
            file.mkdir(words);
        }
        System.out.println();

        // file.ls("user");

        scr.close();
    }
}
