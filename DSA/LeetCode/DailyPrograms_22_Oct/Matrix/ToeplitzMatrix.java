import java.util.Scanner;

public class ToeplitzMatrix {
    public static boolean isToeplitzMatrix(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m - 1; j++) {
                if (matrix[i - 1][j] != matrix[i][j + 1]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int m = scr.nextInt();
        int n = scr.nextInt();
        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scr.nextInt();
            }
        }

        System.out.println(isToeplitzMatrix(matrix));
        scr.close();
    }
}
