import java.util.Scanner;

public class SumOfPrefixScoresOfStrings {
    static class Node {
        int score = 0;
        Node[] child = new Node[26];
    }

    static Node root = new Node(); // Trie root

    private static void add(String str) {
        Node temp = root;

        for (char ch : str.toCharArray()) {
            if (temp.child[ch - 'a'] == null) {
                temp.child[ch - 'a'] = new Node();
            }
            temp.child[ch - 'a'].score++;
            temp = temp.child[ch - 'a'];
        }
    }

    private static int calculate(String str) {
        int ans = 0;

        Node temp = root;

        for (char ch : str.toCharArray()) {
            ans += temp.child[ch - 'a'].score;
            temp = temp.child[ch - 'a'];
        }

        return ans;
    }

    public static int[] sumPrefixScores(String[] words) {
        for (String word : words) {
            add(word);
        }

        int[] res = new int[words.length];

        for (int i = 0; i < res.length; i++) {
            res[i] = calculate(words[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = scr.next();
        }

        int[] ans = sumPrefixScores(words);

        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }

        System.out.println();
        scr.close();
    }
}
