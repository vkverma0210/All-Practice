import java.util.Scanner;

public class WordSearch {
    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        StringBuilder sb = new StringBuilder();
        boolean[][] visited = new boolean[m][n];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (dfs(board, visited, word, r, c, sb)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean dfs(char[][] board, boolean[][] visited, String word, int row, int col, StringBuilder sb) {
        sb.append(board[row][col]);
        visited[row][col] = true;

        if (sb.length() == word.length()) {
            boolean hasFound = sb.toString().equals(word);
            sb.deleteCharAt(sb.length() - 1);
            visited[row][col] = false;
            return hasFound;
        }

        int m = board.length;
        int n = board[0].length;

        int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !visited[newRow][newCol]) {
                if (dfs(board, visited, word, newRow, newCol, sb)) {
                    return true;
                }
            }
        }

        sb.deleteCharAt(sb.length() - 1);
        visited[row][col] = false;
        return false;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int m = scr.nextInt();
        int n = scr.nextInt();

        char[][] board = new char[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = scr.next().charAt(0);
            }
        }

        String word = scr.next();

        System.out.println(exist(board, word));

        scr.close();
    }
}
