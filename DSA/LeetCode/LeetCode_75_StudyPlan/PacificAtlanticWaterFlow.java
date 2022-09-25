import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PacificAtlanticWaterFlow {
    private static void pacificAtlanticHelper(int[][] heights, int i, int j, int prev, int[][] visited) {
        if (i < 0 || j < 0 || i >= heights.length || j >= heights[0].length) {
            return;
        }

        if (visited[i][j] == 1) {
            return;
        }

        if (heights[i][j] < prev) {
            return;
        }

        visited[i][j] = 1;
        pacificAtlanticHelper(heights, i - 1, j, heights[i][j], visited);
        pacificAtlanticHelper(heights, i + 1, j, heights[i][j], visited);
        pacificAtlanticHelper(heights, i, j - 1, heights[i][j], visited);
        pacificAtlanticHelper(heights, i, j + 1, heights[i][j], visited);
    }

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        List<List<Integer>> ans = new ArrayList<>();
        int[][] pacific = new int[n][m];
        int[][] atlantic = new int[n][m];

        for (int col = 0; col < m; col++) {
            pacificAtlanticHelper(heights, 0, col, Integer.MIN_VALUE, pacific);
            pacificAtlanticHelper(heights, n - 1, col, Integer.MIN_VALUE, atlantic);
        }

        for (int row = 0; row < n; row++) {
            pacificAtlanticHelper(heights, row, 0, Integer.MIN_VALUE, pacific);
            pacificAtlanticHelper(heights, row, m - 1, Integer.MIN_VALUE, atlantic);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] == 1 && atlantic[i][j] == 1) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        int m = scr.nextInt();
        int[][] heights = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                heights[i][j] = scr.nextInt();
            }
        }

        System.out.println(pacificAtlantic(heights));
        scr.close();
    }
}
