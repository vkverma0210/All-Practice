import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Tree {
    Tree parent;
    Tree[] val = new Tree[26];
    String word;
    int idx;

    public boolean isEmpty() {
        for (int i = 0; i < 26; i++) {
            if (val[i] != null) {
                return false;
            }
        }

        return true;
    }
}

public class WordSearchII {
    private static final char HASH_TAG = '#';
    private static Tree root = new Tree();

    public static List<String> findWords(char[][] board, String[] words) {
        for (String word : words) {
            Tree temp = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                int idx = word.charAt(i) - 'a';
                if (temp.val[idx] == null) {
                    temp.val[idx] = new Tree();
                    temp.val[idx].parent = temp;
                    temp.val[idx].idx = idx;
                }

                temp = temp.val[idx];
            }
            temp.word = word;
        }

        return searchWord(board);
    }

    private static List<String> searchWord(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                Tree temp = root;
                checkWord(res, i, j, board, temp);
            }
        }

        return res;
    }

    private static void checkWord(List<String> res, int y, int x, char[][] board, Tree temp) {
        if (x >= board[0].length || x < 0 || y >= board.length || y < 0) {
            return;
        }

        char ch = board[y][x];
        if (ch == HASH_TAG || temp.val[ch - 'a'] == null) {
            return;
        }

        temp = temp.val[ch - 'a'];

        if (temp.word != null) {
            res.add(temp.word);
            temp.word = null;
            Tree ptr = temp;
            while (ptr.parent != null && ptr.isEmpty()) {
                int idx = ptr.idx;
                ptr = ptr.parent;
                ptr.val[idx] = null;
            }
        }

        board[y][x] = HASH_TAG;

        checkWord(res, y, x + 1, board, temp);
        checkWord(res, y, x - 1, board, temp);
        checkWord(res, y + 1, x, board, temp);
        checkWord(res, y - 1, x, board, temp);

        board[y][x] = ch;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int m = scr.nextInt();
        char[][] board = new char[m][];
        for (int i = 0; i < m; i++) {
            String s = scr.next();
            board[i] = s.toCharArray();
        }

        int o = scr.nextInt();
        String[] words = new String[o];
        for (int i = 0; i < o; i++) {
            words[i] = scr.next();
        }

        List<String> res = findWords(board, words);
        System.out.println(res);

        scr.close();
    }
}