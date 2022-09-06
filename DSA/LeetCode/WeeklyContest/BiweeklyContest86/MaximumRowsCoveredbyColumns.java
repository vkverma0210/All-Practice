import java.util.Scanner;

public class MaximumRowsCoveredbyColumns {
    public static int maximumRows(int[][] matrix, int numSelect) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] visited = new int[n];

        return maximumRowsHelper(0, m, n, numSelect, matrix, visited);
    }

    public static int maximumRowsHelper(int index, int m, int n, int numSelect, int[][] matrix, int[] visited) {
        if (numSelect == 0) {
            int count = 0;

            for (int i = 0; i < m; i++) {
                boolean selected = true;

                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 1 && visited[j] != 1)
                        selected = false;
                }

                if (selected)
                    count++;
            }

            return count;
        }

        int ans = -1;

        for (int i = index; i < n; i++) {
            visited[i] = 1;
            ans = Math.max(ans, maximumRowsHelper(index + 1, m, n, numSelect - 1, matrix, visited));
            visited[i] = 0;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int m = scr.nextInt();
        int n = scr.nextInt();
        int[][] nums = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = scr.nextInt();
            }
        }

        int cols = scr.nextInt();

        System.out.println(maximumRows(nums, cols));

        scr.close();
    }
}
