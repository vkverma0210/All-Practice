import java.util.Scanner;

public class NumberOfIslands {
    private static void mark_current_islands(char[][] grid, int x, int y, int row, int col) {
        if (x < 0 || x >= row || y < 0 || y >= col || grid[x][y] != '1')
            return;

        // Mark current cell as visited
        grid[x][y] = '2';

        mark_current_islands(grid, x + 1, y, row, col); // Down
        mark_current_islands(grid, x, y + 1, row, col); // Right
        mark_current_islands(grid, x - 1, y, row, col); // Top
        mark_current_islands(grid, x, y - 1, row, col); // Left
    }

    public static int numIslands(char[][] grid) {
        int rows = grid.length;

        if (rows == 0) { // Empty grid boundary condition
            return 0;
        }

        int cols = grid[0].length;

        int no_of_islands = 0;

        // Iterate for all cells of the array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    mark_current_islands(grid, i, j, rows, cols);
                    no_of_islands += 1;
                }
            }
        }

        return no_of_islands;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int m = scr.nextInt();
        int n = scr.nextInt();

        char[][] grid = new char[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = scr.next().charAt(0);
            }
        }

        System.out.println(numIslands(grid));

        scr.close();
    }
}
