import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShortestPathinaGridWithObstaclesElimination {
    public static int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        boolean[][][] visited = new boolean[m][n][k + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { 0, 0, k });
        int res = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            while (size-- > 0) {
                int[] rem = queue.remove();
                int x = rem[0];
                int y = rem[1];
                int obs = rem[2];

                if (x == m - 1 && y == n - 1 && obs >= 0) {
                    return res;
                }

                if (obs < 0 || visited[x][y][obs] == true) {
                    continue;
                }

                visited[x][y][obs] = true;

                // up
                if (x - 1 >= 0) {
                    queue.add(new int[] { x - 1, y, obs - grid[x - 1][y] });
                }

                // down
                if (x + 1 < m) {
                    queue.add(new int[] { x + 1, y, obs - grid[x + 1][y] });
                }

                // left
                if (y - 1 >= 0) {
                    queue.add(new int[] { x, y - 1, obs - grid[x][y - 1] });
                }

                // right
                if (y + 1 < n) {
                    queue.add(new int[] { x, y + 1, obs - grid[x][y + 1] });
                }
            }

            res++;
        }

        return -1;
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

        int k = scr.nextInt();
        System.out.println(shortestPath(grid, k));

        scr.close();
    }
}