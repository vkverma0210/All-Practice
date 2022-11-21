import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NearestExitFromEntranceInMaze {
    public static int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length;
        int cols = maze[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(entrance);
        maze[entrance[0]][entrance[1]] = '+';

        int[][] directions = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        int steps = 0;
        int x, y;
        while (!queue.isEmpty()) {
            steps++;

            int n = queue.size();
            for (int i = 0; i < n; i++) {
                int[] current = queue.poll();

                for (int[] direction : directions) {
                    x = current[0] + direction[0];
                    y = current[1] + direction[1];

                    if (x < 0 || x >= rows || y < 0 || y >= cols || maze[x][y] == '+') {
                        continue;
                    }

                    if (x == 0 || x == rows - 1 || y == 0 || y == cols - 1) {
                        return steps;
                    }

                    maze[x][y] = '+';
                    queue.offer(new int[] { x, y });
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        int m = scr.nextInt();

        char[][] maze = new char[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maze[i][j] = scr.next().charAt(0);
            }
        }

        int[] entrance = new int[2];
        entrance[0] = scr.nextInt();
        entrance[1] = scr.nextInt();

        System.out.println(nearestExit(maze, entrance));

        scr.close();
    }

}