import java.util.Scanner;

public class UniquePaths {
    public static int uniquePaths(int m, int n) {
        int[][] count = new int[m][n];

        for (int i = 0; i < m; i++) {
            count[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            count[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                count[i][j] = count[i - 1][j] + count[i][j - 1];
            }
        }

        return count[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int m = scr.nextInt();
        int n = scr.nextInt();

        System.out.println(uniquePaths(m, n));
        scr.close();
    }
}
