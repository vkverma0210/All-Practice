// 2 3
// 4 5

// 4 5
// 6 7

// 6 8
// 10 12
public class Test1 {
    private static int[][] solve(int[][] a, int[][] b) {
        int m = a.length;
        int n = a[0].length;

        int[][] ans = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = a[i][j] + b[i][j];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] a = new int[][] { { 2, 3 }, { 4, 5 } };
        int[][] b = new int[][] { { 4, 5 }, { 6, 7 } };

        System.out.println("Matrix 1");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }

            System.out.println();
        }

        System.out.println("Matrix 2");
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                System.out.print(b[i][j] + " ");
            }

            System.out.println();
        }

        int[][] ans = solve(a, b);

        System.out.println("Output");
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }

            System.out.println();
        }
    }
}
