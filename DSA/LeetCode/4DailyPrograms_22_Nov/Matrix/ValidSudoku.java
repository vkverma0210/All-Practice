import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char num = board[row][col];
                if (num != '.') {
                    if (!set.add(num + " in row " + row) || !set.add(num + " in column " + col)
                            || !set.add(num + " in block " + (row / 3) + ", " + (col / 3))) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        int m = scr.nextInt();

        char[][] board = new char[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = scr.next().charAt(0);
            }
        }

        System.out.println(isValidSudoku(board));

        scr.close();
    }
}