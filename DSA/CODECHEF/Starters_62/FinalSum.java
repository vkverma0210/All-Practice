import java.util.Scanner;

public class FinalSum {
    public static int solve(int n, int q, int[] arr, int[][] queries) {
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        for (int i = 0; i < q; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int sub = 0, add = 0;

            int diff = r - l + 1;

            if (diff % 2 != 0) {
                sub = diff / 2;
                add = diff - sub;
            }

            sum = sum + add - sub;
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int n = scr.nextInt();
            int q = scr.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scr.nextInt();
            }

            int[][] queries = new int[q][2];
            for (int i = 0; i < q; i++) {
                queries[i][0] = scr.nextInt();
                queries[i][1] = scr.nextInt();
            }

            System.out.println(solve(n, q, arr, queries));

            t--;
        }

        scr.close();
    }
}
