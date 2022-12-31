import java.util.Scanner;

public class UniquePathsIII {
    public static int uniquePathsIII(int[][] grid) {
        int zero = 0, a = 0, b = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 0) {
                    zero++;
                } else if (grid[r][c] == 1) {
                    a = r;
                    b = c;
                }
            }
        }

        return path(grid, a, b, zero);
    }

    private static int path(int[][] grid, int x, int y, int zero) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == -1) {
            return 0;
        }

        if (grid[x][y] == 2) {
            return zero == -1 ? 1 : 0;
        }

        grid[x][y] = -1;
        zero--;

        int totalCount = path(grid, x + 1, y, zero) + path(grid, x, y + 1, zero) + path(grid, x - 1, y, zero)
                + path(grid, x, y - 1, zero);

        grid[x][y] = 0;
        zero++;

        return totalCount;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int m = scr.nextInt();
        int n = scr.nextInt();

        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = scr.nextInt();
            }
        }

        System.out.println(uniquePathsIII(grid));
        scr.close();
    }
}
