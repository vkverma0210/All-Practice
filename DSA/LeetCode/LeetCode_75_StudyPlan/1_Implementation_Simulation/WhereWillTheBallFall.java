import java.util.Scanner;

public class WhereWillTheBallFall {
    public static int[] findBall(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[] res = new int[col];

        for (int i = 0; i < col; i++) {
            int i1 = i, i2;
            for (int j = 0; j < row; j++) {
                i2 = i1 + grid[j][i1];

                if (i2 < 0 || i2 >= col || grid[j][i2] != grid[j][i1]) {
                    i1 = -1;
                    break;
                }

                i1 = i2;
            }

            res[i] = i1;
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        int m = scr.nextInt();

        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = scr.nextInt();
            }
        }

        int[] res = findBall(grid);

        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();

        scr.close();
    }
}
