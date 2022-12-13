import java.util.Scanner;

public class MinimumFallingPathSum {
    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int best = matrix[i + 1][j];
                if (j > 0)
                    best = Math.min(best, matrix[i + 1][j - 1]);

                if (j + 1 < n)
                    best = Math.min(best, matrix[i + 1][j + 1]);

                matrix[i][j] += best;
            }
        }

        int mini = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {
            mini = Math.min(mini, matrix[0][j]);
        }

        return mini;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scr.nextInt();
            }
        }

        System.out.println(minFallingPathSum(matrix));
        scr.close();
    }
}