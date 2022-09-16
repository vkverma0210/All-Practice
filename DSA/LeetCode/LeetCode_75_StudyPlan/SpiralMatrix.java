import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ls = new ArrayList<>();
        if (matrix.length == 0)
            return ls;

        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // traverse Right
            for (int i = colBegin; i <= colEnd; i++) {
                ls.add(matrix[rowBegin][i]);
            }

            rowBegin++;

            // traverse Down
            for (int i = rowBegin; i <= rowEnd; i++) {
                ls.add(matrix[i][colEnd]);
            }
            colEnd--;

            // Traverse left
            if (rowBegin <= rowEnd) {
                for (int i = colEnd; i >= colBegin; i--) {
                    ls.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;

            // traverse Up
            if (colBegin <= colEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    ls.add(matrix[i][colBegin]);
                }
            }
            colBegin++;
        }

        return ls;
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

        List<Integer> res = spiralOrder(matrix);
        System.out.println(res);

        scr.close();
    }
}
