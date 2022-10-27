import java.util.Scanner;

public class NumberofIslands {
    private static void numIslandsHelper(char[][] grid, int i, int j, int rows, int cols) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] != '1') {
            return;
        }

        grid[i][j] = '2';

        numIslandsHelper(grid, i + 1, j, rows, cols);
        numIslandsHelper(grid, i - 1, j, rows, cols);
        numIslandsHelper(grid, i, j + 1, rows, cols);
        numIslandsHelper(grid, i, j - 1, rows, cols);
    }

    public static int numIslands(char[][] grid) {
        int rows = grid.length;

        if (rows == 0) {
            return 0;
        }

        int cols = grid[0].length;

        int no_of_islands = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    numIslandsHelper(grid, i, j, rows, cols);
                    no_of_islands++;
                }
            }
        }

        return no_of_islands;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        int m = scr.nextInt();

        char[][] grid = new char[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = scr.next().charAt(0);
            }
        }

        System.out.println(numIslands(grid));
        scr.close();
    }
}
