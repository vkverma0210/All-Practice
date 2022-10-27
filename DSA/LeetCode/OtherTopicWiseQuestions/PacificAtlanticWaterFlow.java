import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PacificAtlanticWaterFlow {
    static boolean checkPacific(int[][] arr, int i, int j, boolean[][] vis) {
        // any cell in 1st row and 1st column will definitely send the water to pacific
        // ocean
        if (i <= 0 || j <= 0)
            return true;

        if (i >= arr.length || j >= arr[0].length || vis[i][j])
            return false;

        vis[i][j] = true;

        // check for top
        if (i > 0 && arr[i - 1][j] <= arr[i][j]) {
            if (checkPacific(arr, i - 1, j, vis))
                return true;
        }

        // check for bottom
        if (i < arr.length - 1 && arr[i + 1][j] <= arr[i][j]) {
            if (checkPacific(arr, i + 1, j, vis))
                return true;
        }

        // check for left
        if (j > 0 && arr[i][j - 1] <= arr[i][j]) {
            if (checkPacific(arr, i, j - 1, vis))
                return true;
        }

        // check for right
        if (j < arr[0].length - 1 && arr[i][j + 1] <= arr[i][j]) {
            if (checkPacific(arr, i, j + 1, vis))
                return true;
        }

        vis[i][j] = false;
        return false;
    }

    static boolean checkAtlantic(int[][] arr, int i, int j, boolean[][] vis) {
        // any cell in last row and last column will definitely send the water to
        // atlantic ocean
        if (i >= arr.length - 1 || j >= arr[0].length - 1)
            return true;

        if (i < 0 || j < 0 || vis[i][j])
            return false;

        vis[i][j] = true;

        // check for top
        if (i > 0 && arr[i - 1][j] <= arr[i][j]) {
            if (checkAtlantic(arr, i - 1, j, vis))
                return true;
        }

        // check for bottom
        if (i < arr.length - 1 && arr[i + 1][j] <= arr[i][j]) {
            if (checkAtlantic(arr, i + 1, j, vis))
                return true;
        }

        // check for left
        if (j > 0 && arr[i][j - 1] <= arr[i][j]) {
            if (checkAtlantic(arr, i, j - 1, vis))
                return true;
        }

        // check for right
        if (j < arr[0].length - 1 && arr[i][j + 1] <= arr[i][j]) {
            if (checkAtlantic(arr, i, j + 1, vis))
                return true;
        }

        vis[i][j] = false;
        return false;
    }

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        boolean[][] vis;

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                vis = new boolean[n][m];
                boolean a = checkPacific(heights, i, j, vis);

                vis = new boolean[n][m];
                boolean b = checkAtlantic(heights, i, j, vis);

                if (a && b) {
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

        List<List<Integer>> ans = pacificAtlantic(heights);

        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i).get(0) + " " + ans.get(i).get(1));
            System.out.println();
        }

        scr.close();
    }
}
