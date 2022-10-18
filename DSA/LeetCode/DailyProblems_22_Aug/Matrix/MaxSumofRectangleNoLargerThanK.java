import java.util.TreeSet;
import java.util.Scanner;

public class MaxSumofRectangleNoLargerThanK {
    public static int maxSumSubmatrix(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < row; i++) {
            int[] colSum = new int[col];

            for (int j = i; j < row; j++) {
                for (int c = 0; c < col; c++) {
                    colSum[c] += matrix[j][c];
                }

                max = Math.max(max, find(colSum, k));
            }
        }

        return max;
    }

    private static int find(int[] sum, int k) {
        int result = Integer.MIN_VALUE;

        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        int prefixSum = 0;

        for (int i = 0; i < sum.length; i++) {
            prefixSum += sum[i];

            Integer target = set.ceiling(prefixSum - k);

            if (target != null) {
                result = Math.max(result, prefixSum - target);
            }

            set.add(prefixSum);
        }

        return result;
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

        int k = scr.nextInt();

        System.out.println(maxSumSubmatrix(matrix, k));

        scr.close();
    }
}
