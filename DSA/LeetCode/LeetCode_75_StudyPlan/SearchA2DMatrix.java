import java.util.Scanner;

public class SearchA2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length - 1;

        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        int m = scr.nextInt();
        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scr.nextInt();
            }
        }

        int target = scr.nextInt();

        System.out.println(searchMatrix(matrix, target));
        scr.close();
    }
}
