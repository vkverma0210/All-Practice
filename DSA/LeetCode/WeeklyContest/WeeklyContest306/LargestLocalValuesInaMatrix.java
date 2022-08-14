import java.util.Scanner;

public class LargestLocalValuesInaMatrix {
    public static int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int ans[][] = new int[n - 2][n - 2];

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans.length; j++) {
                int largest = Integer.MIN_VALUE;

                for (int row = i; row < i + 3; row++) {
                    for (int column = j; column < j + 3; column++) {
                        largest = Math.max(largest, grid[row][column]);
                    }
                }

                ans[i][j] = largest;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();

        int[][] grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = scr.nextInt();
            }
        }

        int[][] ans = new int[n - 2][n - 2];

        ans = largestLocal(grid);

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                System.out.print(ans[i][j]);
            }

            System.out.println();
        }

        scr.close();
    }
}
