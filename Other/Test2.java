public class Test2 {
    public static void main(String[] args) {
        int n = 4;
        int m = 5;
        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(grid[i][j]);
            }

            System.out.println();
        }
    }
}
