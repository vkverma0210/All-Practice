import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class Node {
    // Use a treeMap to maintain the insertion order
    TreeMap<Character, Node> children;
    boolean endOfWord;

    Node() {
        children = new TreeMap<>();
        endOfWord = false;
    }
}

public class LongestCommonPrefix {
    Node root;

    // insert the character in trie
    public void insert(String word) {
        Node curr = this.root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (curr.children.get(ch) == null) {
                curr.children.put(ch, new Node());
            }

            curr = curr.children.get(ch);
        }

        curr.endOfWord = true;
    }

    public String longestCommonPrefixHelper() {
        StringBuilder result = new StringBuilder();
        Node curr = this.root;

        while (curr != null && !curr.endOfWord && curr.children.size() == 1) {
            Iterator<Map.Entry<Character, Node>> treeMapIterator = curr.children.entrySet().iterator();

            if (treeMapIterator.hasNext()) {
                Map.Entry<Character, Node> entry = treeMapIterator.next();
                result.append(entry.getKey());
                curr = entry.getValue();
            }
        }

        return result.toString();
    }

    public static String longestCommonPrefix(String[] strs) {
        LongestCommonPrefix trieobj = new LongestCommonPrefix();
        trieobj.root = new Node();

        if (strs == null || strs.length == 0) {
            return new String("");
        }

        for (String s : strs) {
            trieobj.insert(s);
        }

        return trieobj.longestCommonPrefixHelper();
    }

    public static String longestCommonPrefix_String(String[] strs) {
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }

        return prefix;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();

        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = scr.next();
        }

        System.out.println(longestCommonPrefix(words));

        scr.close();
    }
}
